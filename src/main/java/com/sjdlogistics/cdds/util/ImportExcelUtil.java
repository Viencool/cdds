package com.sjdlogistics.cdds.util;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

public class ImportExcelUtil {
    //log4j输出
    private Logger logger = Logger.getLogger(this.getClass());
    // 时间的格式
    private String format = "yyyy-MM-dd";

    /**
     * 构造设置显示时间的格式
     *
     * @param format 例："yyyy-MM-dd"
     */
    public ImportExcelUtil(String format) {
        super();
        this.format = format;
    }

    /**
     * 设置显示时间的格式
     *
     * @param format 例："yyyy-MM-dd"
     */
    public void setFormat(String format) {
        this.format = format;
    }

    /**
     * @param originalFilename
     * @return 1 ：2003
     * 2 ：2007
     * 0 ：不是Excle版本
     * @描述：判断Excel是什么版本
     */
    public int isExcleVersion(String originalFilename) {
        int flag = 0;
        if (originalFilename.matches("^.+\\.(?i)(xls)$")) flag = 1;
        else if (originalFilename.matches("^.+\\.(?i)(xlsx)$")) flag = 2;
        return flag;
    }

    /**
     * 读取properties文件中定义的文件存储路径
     *
     * @param propertiesFileName
     * @param keyName
     * @return value值
     */
    public String readPropertiesFilePath(String propertiesFileName, String keyName) {

        InputStream inputStream = null;
        String filePath = null;
        //读取的文件路径
        try {
            inputStream = new FileInputStream(this.getClass().getClassLoader().getResource("/" + propertiesFileName + ".properties").getPath());
            Properties properties = new Properties();
            properties.load(inputStream);
            filePath = properties.getProperty(keyName);
        } catch (FileNotFoundException e1) {
            logger.error("未找到properties文件！", e1);
        } catch (IOException e1) {
            logger.error("打开文件流异常！", e1);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    logger.error("关闭文件流异常！", e);
                }
            }
        }
        return filePath;
    }

    /**
     * SpringMVC 上传Excle文件至本地
     *
     * @param multipart
     * @param filePath    上传至本地的文件路径    例：D:\\fileupload
     * @param isExcel2003 是否是2003版本的Excle文件
     * @return 返回上传文件的全路径
     * @throws Exception
     */
    public void upload(MultipartFile multipart, String filePath, boolean isExcel2003) throws Exception {
        //文件后缀
        String extension = ".xlsx";
        if (isExcel2003) extension = ".xls";
        //指定上传文件的存储路径
        File file = new File(filePath);
        //接口强转实现类
        CommonsMultipartFile commons = (CommonsMultipartFile) multipart;
        //判断所属路径是否存在、不存在新建
        if (!file.exists()) file.mkdirs();
        //新建一个文件
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
        File filePathname = new File(file + File.separator + df.format(new Date()) + extension);
        //将上传的Excel写入新建的文件中
        try {
            commons.getFileItem().write(filePathname);
        } catch (Exception e) {
            logger.error("写入文件异常", e);
        }
    }

    /**
     * 读取本地Excel文件返回List集合
     *
     * @param file
     * @param clazzVsTitleAndAttribute
     * @return
     * @throws Exception
     */
    public Map<Class,List> readExcelReList(MultipartFile file, Map<Class, Map<String, String>> clazzVsTitleAndAttribute,
                                               List<Class> clazzList) throws Exception {

        String fileName = file.getOriginalFilename();
        int flag = isExcleVersion(fileName);
        if(flag == 0) throw new Exception("导入文件不是EXCEL文件！");
        Workbook workbook = null;
            //打开流
            InputStream is = file.getInputStream();
            if (flag == 1) {
                //把excel文件作为数据流来进行传入传出
                POIFSFileSystem fs = new POIFSFileSystem(is);
                //解析Excel 2003版
                workbook = new HSSFWorkbook(fs);
            } else {
                //解析Excel 2007版
                workbook = new XSSFWorkbook(is);
            }


        Map<Class,List> maps = new HashMap<Class, List>();
        int sheetNums = workbook.getNumberOfSheets();

        for(int sheetIndex = 0; sheetIndex < sheetNums; sheetIndex++){
            if(sheetIndex > clazzList.size()) break;
            Class clazz = clazzList.get(sheetIndex);
            List<Object > ojbList = readExcelTitle(workbook, sheetIndex, clazzVsTitleAndAttribute.get(clazz), clazz);
            if(maps.get(clazz) == null) maps.put(clazz,ojbList);
            else maps.get(clazz).addAll(ojbList);
        }
        return maps;
    }

    /**
     * 判断接收的Map集合中的标题是否于Excle中标题对应
     *
     * @param workbook
     * @param sheetIndex
     * @param titleAndAttribute
     * @param clazz
     * @return
     * @throws Exception
     */
    private List<Object > readExcelTitle(Workbook workbook, int sheetIndex, Map<String, String> titleAndAttribute, Class clazz) throws Exception {
        Sheet sheet = workbook.getSheetAt(sheetIndex);
        // 获取标题
        Row titelRow = sheet.getRow(0);
        //列标与clazz的属性名对应关系Map
        Map<Integer, String> cellNumAndAttribute = new HashMap<Integer, String>();
        for (int cellIndex = 0; cellIndex < titelRow.getLastCellNum(); cellIndex++) {
            Cell cell = titelRow.getCell(cellIndex);
            if (cell != null) {
                String title = cell.getStringCellValue();
                String attribute = titleAndAttribute.get(title);
                if (attribute == null)
                    throw new Exception("表空间：" + sheet.getSheetName() + "列名:" + title + "找不到对应文件属性！");
                cellNumAndAttribute.put(Integer.valueOf(cellIndex), attribute);
            }
        }
        return readExcelValue(sheet, cellNumAndAttribute, clazz);

    }

    /**
     * 获取Excle中的值组装成class的集合
     *
     * @param sheet
     * @param cellNumAndAttribute
     * @param clazz
     * @return
     * @throws Exception
     */
    private List<Object > readExcelValue(Sheet sheet, Map<Integer, String> cellNumAndAttribute, Class clazz) throws Exception {
        List<Object > info = new ArrayList<Object >();
        //获取标题行列数
        int titleCellNum = sheet.getRow(0).getLastCellNum();
        // 获取值
        for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
            Row row = sheet.getRow(rowIndex);
            // 若当前行的列数不等于标题行列数就放弃整行数据
            /*int lastCellNum = row.getLastCellNum();
            if (titleCellNum != lastCellNum) {
                continue;
            }*/
            List<String> exclusions = Arrays.asList("unit1","unit2","qty1","qty2");
            Object  obj = clazz.newInstance();
            for (int cellIndex = 0; cellIndex < titleCellNum; cellIndex++) {
                Cell cell = row.getCell(cellIndex);
                //处理单元格中值得类型
                Field field = clazz.getDeclaredField(cellNumAndAttribute.get(Integer.valueOf(cellIndex)));
                String value = (getCellValue(cell) == null)? "":getCellValue(cell);
                if(getCellValue(cell) == "" || getCellValue(cell) == null){
                    if(exclusions.contains(field.getName())){
                        value = null;
                    }
                }
                Class<?> fieldType = field.getType();
                Object fieldValue = null;
                 if (fieldType.isAssignableFrom(Integer.class)) {
                    fieldValue = Integer.valueOf(value);
                } else if (fieldType.isAssignableFrom(Double.class)) {
                    fieldValue = Double.valueOf(value);
                } else if (fieldType.isAssignableFrom(Float.class)) {
                    fieldValue = Float.valueOf(value);
                } else if (fieldType.isAssignableFrom(Long.class)) {
                    fieldValue = Long.valueOf(value);
                } else if (fieldType.isAssignableFrom(Date.class)) {
                    fieldValue = new SimpleDateFormat(format).format(cell.getDateCellValue());
                } else if (fieldType.isAssignableFrom(Boolean.class)) {
                    fieldValue = "Y".equals(value) || "1".equals(value);
                } else if (fieldType.isAssignableFrom(String.class)) {
                    fieldValue = value;
                } else if (fieldType.isAssignableFrom(BigDecimal.class)) {
                    if(value == "") {fieldValue = null;}
                    else fieldValue = new BigDecimal(cell.getNumericCellValue());
                }else if(fieldType.isAssignableFrom(Short.class)){
                    if(value == "") {fieldValue = null;}
                    else fieldValue = (short)cell.getNumericCellValue();
                }
                // 个人感觉char跟byte就不用判断了 用这两个类型的很少如果是从数据库用IDE生成的话就不会出现了
                Method method = clazz.getMethod("set" + toUpperFirstCase(cellNumAndAttribute.get(Integer.valueOf(cellIndex))), fieldType);
                method.invoke(obj, fieldValue);

            }
            info.add(obj);
        }
        return info;
    }

    /**
     * @ 首字母大写
     */
    private String toUpperFirstCase(String str) {
        return str.replaceFirst(str.substring(0, 1), str.substring(0, 1).toUpperCase());
    }

    /**
     * 功能:处理单元格中值得类型
     *
     * @param cell
     * @return
     */
    private String getCellValue(Cell cell) {
        Object result = "";
        if (cell != null) {
            switch (cell.getCellTypeEnum()) {
                case STRING:
                    result = cell.getStringCellValue();
                    break;
                case NUMERIC:
                    //判断是是日期型，转换日期格式，否则转换数字格式。
                    if (DateUtil.isCellDateFormatted(cell)) {
                        Date dateCellValue = cell.getDateCellValue();
                        if (dateCellValue != null) {
                            result = new SimpleDateFormat(this.format).format(dateCellValue);
                        } else {
                            result = "";
                        }
                    } else {
                        long longVal = Math.round(cell.getNumericCellValue());
                        if (Double.parseDouble(longVal + ".0") == cell.getNumericCellValue()) {
                            result = longVal;
                        } else {
                            result = cell.getNumericCellValue();
                        }
                    }
                    break;
                case BOOLEAN:
                    result = cell.getBooleanCellValue();
                    break;
                case FORMULA:
                    result = cell.getCellFormula();
                    break;
                case ERROR:
                    result = cell.getErrorCellValue();
                    break;
                case BLANK:
                    break;
                default:
                    break;
            }
        }
        return result.toString();
    }
}

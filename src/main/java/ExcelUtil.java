import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExcelUtil {

    public static boolean WriteExcel(List<Obj> list) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss");
        String excelFile = "G:\\爬取当当\\"+sdf.format(new Date())+".xlsx";
        // 内存中只创建100个对象，写临时文件，当超过100条，就将内存中不用的对象释放。
        SXSSFWorkbook sxss = new SXSSFWorkbook(100);
        SXSSFSheet sheet = sxss.createSheet();
        try {
            //遍历List获取数据
            Row rowhead = sheet.createRow(0);
            for (int i = 0; i < list.size(); i++) {//行数
                Obj data = list.get(i);
                Row row = sheet.createRow(i+1);
                row.setRowStyle(sxss.createCellStyle());
                List<String> body = new ArrayList<>();
                body.add(data.getBookName());
                body.add(data.getAuthor());
                body.add(data.getPublishTime());
                body.add(data.getRank());
                body.add(data.getPrice_n());
                body.add(data.getPrice_r());
                body.add(data.getPrice_s());
                body.add(data.getCommentnum());
                body.add(data.getImgurl());
                String[] heads = new String[]{"书名","作者","出版时间","排名","现价","原价","折扣","评论数","图片地址"};
                for (int j = 0; j <heads.length ; j++) {
                    if(i==0){//在第一行 插入表头
                        rowhead.createCell(j).setCellValue(heads[j]);
                    }
                    row.createCell(j).setCellValue(body.get(j));//列数
                }

            }
            System.err.println("创建"+excelFile+"成功！");
            FileOutputStream fOut = new FileOutputStream(excelFile);//将数据写入Excel
            sxss.write(fOut);
            fOut.flush(); // 刷新缓冲区
            fOut.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void createRow(List<Obj> list, int i, Cell nCell){
        System.out.println(list.get(i));
        nCell.setCellValue(list.get(i).getBookName());
        nCell.setCellValue(list.get(i).getAuthor());
        nCell.setCellValue(list.get(i).getPublishTime());
        nCell.setCellValue(list.get(i).getRank());
        nCell.setCellValue(list.get(i).getCommentnum());
        nCell.setCellValue(list.get(i).getPrice_n());
        nCell.setCellValue(list.get(i).getPrice_r());
        nCell.setCellValue(list.get(i).getPrice_s());
        nCell.setCellValue(list.get(i).getImgurl());
    }
}

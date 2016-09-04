package com.s.yhcy.util;

import com.s.yhcy.entity.Gsxd;
import com.s.yhcy.entity.Item;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/**
 * Excel导入导出工具
 * Created by PawN on 2016/9/4.
 */
public class ExcelUtil {
    public static List<Gsxd> getGsxdListFromExcel(File file) {
        List<Gsxd> list = new ArrayList<>();
        try {
            Workbook rwb = Workbook.getWorkbook(file);
            Sheet sheet = rwb.getSheet(0);
            int rows = sheet.getRows();
            for (int i = 1; i < rows; i++) {
                Gsxd gsxd = new Gsxd();
                gsxd.setZhang(new Item(sheet.getCell(0,i).getContents(),sheet.getCell(1,i).getContents()));
                gsxd.setJie(new Item(sheet.getCell(2,i).getContents(),sheet.getCell(3,i).getContents()));
                gsxd.setXiaoJie(new Item(sheet.getCell(4,i).getContents(),sheet.getCell(5,i).getContents()));
                gsxd.setNeiRong(new Item(sheet.getCell(6,i).getContents(),sheet.getCell(7,i).getContents()));
                list.add(gsxd);
            }
            rwb.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }
        return list;
    }
}

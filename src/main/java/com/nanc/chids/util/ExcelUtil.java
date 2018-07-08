package com.nanc.chids.util;

import com.nanc.chids.po.MemberPo;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public final class ExcelUtil {

    public static List<MemberPo> parseExcel(InputStream inputStream) {
        List<MemberPo> list = new ArrayList<>();
        try {
            Workbook workbook = Workbook.getWorkbook(inputStream);
            Sheet sheet = workbook.getSheet(0);
            if (sheet != null) {

                for (int i = 1; i < sheet.getRows(); i++) {
                    Cell[] cells = sheet.getRow(i);
                    MemberPo memberPo = new MemberPo();
                    memberPo.setId(Integer.valueOf(cells[0].getContents()));
                    memberPo.setName(cells[1].getContents());
                    memberPo.setSex(cells[2].getContents());
                    memberPo.setBirthDay(cells[3].getContents());
                    memberPo.setEnterDate(cells[4].getContents());
                    memberPo.setGraduatedDate(cells[5].getContents());
                    memberPo.setStudyStyle(cells[6].getContents());
                    memberPo.setGraduateMajor(cells[7].getContents());
                    memberPo.setGraduateSchool(cells[8].getContents());
                    memberPo.setStudyType(cells[9].getContents());
                    memberPo.setLevel(cells[10].getContents());
                    memberPo.setCollegeLocation(cells[11].getContents());
                    memberPo.setCardNo(cells[12].getContents());
                    memberPo.setCheckCode(cells[13].getContents());
                    memberPo.setPresident(cells[14].getContents());
                    memberPo.setUpdateDate(cells[15].getContents());
                    memberPo.setSelfMajor(cells[16].getContents());
                    memberPo.setIdCardNo(cells[17].getContents());
                    memberPo.setCardNo2(cells[18].getContents());
                    memberPo.setLength(cells[19].getContents());
                    memberPo.setQRCode(cells[20].getContents());
                    memberPo.setPhoto(cells[21].getContents());
                    list.add(memberPo);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void main(String[] args) throws Exception{
        List<MemberPo> list = parseExcel(new FileInputStream("d:/data.xls"));
        for(MemberPo memberPo:list){
            //NameImgCreateHelper.create(memberPo.getName(),memberPo.getIdCardNo());
        }
    }


}

package com.simpleJavaProgram;

public class SeriesInsert {


    public static void main(String[] args) {
        将Excel数据转为Insert语句();
    }



    private static void 将Excel数据转为Insert语句() {

        String[] fields = fields_str.replaceAll("\n", "").split("\t");
        int fieldsNum = fields.length;
        String[] all = records_str.split("\t");
        打印insert固定开头(tableName, fields, fieldsNum);
        for (int i = 0; i < fieldsNum-1; i++) {
            System.out.print("'"+all[i].replaceAll("\n", "<换行>") + "', ");
        }
        System.out.println("'"+all[fieldsNum-1].substring(0, all[fieldsNum-1].lastIndexOf("\n")).replaceAll("\n", "<换行>") + "');");
        for (int i = fieldsNum; i < all.length; i+=fieldsNum-1) {
            打印insert固定开头(tableName, fields, fieldsNum);
            System.out.print("'"+all[i-1].substring(all[i-1].lastIndexOf("\n")+1).replaceAll("\n", "<换行>") + "', ");
            for (int j = 0; j < fieldsNum-2; j++) {
                System.out.print("'"+all[i+j].replaceAll("\n", "<换行>") + "', ");
            }
            System.out.println("'"+all[i+fieldsNum-2].substring(0, all[i+fieldsNum-2].lastIndexOf("\n")).replaceAll("\n", "<换行>") + "');");
        }

    }

    private static void 打印insert固定开头(String tableName, String[] fields, int fieldsNum) {
        System.out.print("INSERT INTO " + tableName + "(");
        for (int i = 0; i < fields.length-1; i++) {
            System.out.print(fields[i] + ", ");
        }
        System.out.print(fields[fieldsNum -1] + ") VALUES (");
    }



    //  表名
    static String tableName = "D_SERIES";

    // 字段名
    static String fields_str = "XL_SIMPLE\tXL_FULL\tNM_JP\tNM_CN\tFH_PATTERN\tFH_RULER\tGD_PRODUCER\tGD_MOSAIC\tGD_SUB_SERIES\tMS_RESUME\tMS_DETAIL\n";

    // 数据
    static String records_str = "n\tn\tn\tn\t步兵\tTokyo-Hot\tnxxxx\tn开头的已经排到八百多，如n0680，都是多人演出。\t\tn开头的已经排到八百多，如n0680，都是多人演出。\t \n" +
            "k\tk\tk\tk\t步兵\tTokyo-Hot\tkxxxx\tK开头的为素人片，多以二人演出。\t\tK开头的为素人片，多以二人演出。\t \n" +
            "1pon\t1Pondo\t一本道\t一本道\t步兵\t1Pondo\tMMddyy-xxx\t番号多为一串数字，如022313-538,前六位数字表示发行日期，后三位是影片编号。\tDrama Collection（ドラマコレクション）,Gravure Collection,Princess Collection,Model Collection\t番号多为一串数字，如022313-538,前六位数字表示发行日期，后三位是影片编号。\t \n" +
            "carib\tCaribbeancom\tカリビアンコム\t加勒比\t步兵\tCaribbean\tMMddyy-xxx\t番号多为一串数字，如022313-538,前六位数字表示发行日期，后三位是影片编号\t密室**,女热大陆（Erotic Documentary）,THE 未公开,新入社员のお仕事（School Girl Uniform Club）,禁じられた关系,极上本物泡姫物,见晴らし最高,初めてのAV（My First Time Porn Filming）,美★ジーンズ,カリビアンキューティー（Caribbean Cutie）,夏の想い出（Sweet Summer Memory ）\t番号多为一串数字，如022313-538,前六位数字表示发行日期，后三位是影片编号\t \n" +
            "Sky\tSky\t空天使\t空天使\t步兵\tSky High Entertainment\tSky-xxx\tsky加3位数字序号组成\tSkyAngel,GoldAngel,好色妻降临,美熟女,X COLLECTION系列\tsky加3位数字序号组成\t \n" +
            "RHJ\tRed Hot Jam\t红热果酱\t红热果酱\t步兵\tRED HOT Collection\tRHJ-xxx\tRHJ加3位数字序号组成\t\tRHJ加3位数字序号组成\t \n" +
            "Red\tRed Hot Fetish Collection\t红色\t红色\t步兵\tRED HOT Collection\tRED-xxx\tRED加3位数字序号组成\t\"Red Hot Fetish Collection\n" +
            "Hot Debut Collection File\"\tRED加3位数字序号组成\t \n" +
            "CRD\tRED HOT IDOL\t红色\t红色\t步兵\tRED HOT Collection\tCRD-xxx\tCRD加3位数字序号组成\tRED HOT IDOL\tCRD加3位数字序号组成\t \n" +
            "SMD\tSMD\t超级名模\t超级名模\t步兵\tSuper Model Media\tSMD-x\tSMD加序号组成\t\tSMD加序号组成\t\n" +
            "SMDV\tSMDV\t超级名模\t超级名模\t步兵\tSuper Model Media\tSMDV-x\tSMDV加序号组成\t\tSMDV加序号组成\t\n" +
            "SMBD\tSMBD\t超级名模\t超级名模\t步兵\tSuper Model Media\tSMBD-x\tSMBD加序号组成\t\tSMBD加序号组成\t\n" +
            "SM3D2DBD\tSM3D2DBD\t超级名模\t超级名模\t步兵\tSuper Model Media\tSM3D2DBD-x\tSM3D2DBD加序号组成\t\tSM3D2DBD加序号组成\t\n" +
            "CWP\tCATWALK POISON\t猫步毒药\t猫步毒药\t步兵\tCATWALK Entertainment\tCWP-x\tCWP加序号组成\t\tCWP加序号组成\t\n" +
            "CWPBD\tCATWALK POISON BD\t猫步毒药\t猫步毒药\t步兵\tCATWALK Entertainment\tCWPBD-x\tCWP加序号组成\t\tCWP加序号组成\t\n" +
            "CWDV\tCATWALK POISON DV\t猫步毒药\t猫步毒药\t步兵\tCATWALK Entertainment\tCWDV-x\tCWDV加序号组成\t\tCWDV加序号组成\t\n" +
            "CW3D2DBD\tCATWALK POISON DV\t猫步毒药\t猫步毒药\t步兵\tCATWALK Entertainment\tCW3D2DBD-x\tCWDV加序号组成\t\tCWDV加序号组成\t\n" +
            "MX\tMX\tMX\tMX\t步兵\tMUGEN Entertainment\tMX-x\t\t\t\t\n" +
            "MG\tMG\tMG\tMG\t步兵\tMUGEN Entertainment\tMG-x\t\t\t\t\n" +
            "MW\tMW\tMW\tMW\t步兵\tMUGEN Entertainment\tMW-x\t\t\t\t\n" +
            "MUD\tMUD\tMUD\tMUD\t步兵\tMUGEN Entertainment\tMUD-x\t\t\t\t\n" +
            "MKD-S\tMKD-S\tMKD-S\tMKD-S\t步兵\tMUGEN Entertainment\tMKD-S-x\t\t\t\t\n" +
            "MKBD-S\tMKBD-S\tMKBD-S\tMKBD-S\t步兵\tMUGEN Entertainment\tMKBD-S-x\t\t\t\t\n" +
            "s2m\ts2m\ts2m\ts2m\t步兵\tstage 2 media\ts2mxxx\t\t\t\t\n" +
            "s2mbd\ts2mbd\ts2mbd\ts2mbd\t步兵\tstage 2 media\ts2mbdxxx\t\t\t\t\n" +
            "KP\tKamikaze Premium\t神风特攻队\t神风特攻队\t步兵\tKamikaze Entertainment\tKP-x\t\t\t\t\n" +
            "KS\tKamikaze Street\t神风街\t神风街\t步兵\tKamikaze Entertainment\tKS-x\t\t\t\t\n" +
            "KG\tKamikaze Girls\t神风女孩\t神风女孩\t步兵\tKamikaze Entertainment\tKG-x\t\t\t\t\n" +
            "FH\tFetish Hood\t恋物癖\t恋物癖\t步兵\tOriental Dream\tFH-x\t\t\t\t\n" +
            "TRP\tPLATINUM\t\t\t步兵\tTora-Tora-Tora\tTRP-x\t\t\t\t\n" +
            "TRG\tGold\t\t\t步兵\tTora-Tora-Tora\tTRG-x\t\t\t\t\n" +
            "HEYZO\tHEYZO\t\t\t步兵\tHEYZO\tHEYZO-xxxx\t\t\t\t\n" +
            "KSC\tKOKESHI COWGIRL\t\t\t步兵\tKOKESHI\tKSC-x\t\t\t\t\n" +
            "YZD\tYZD\t\t\t步兵\tYuzu\tYZD-xxx\t\t\t\t\n" +
            "GOD\tGOD\t\t\t步兵\tYuzu\tGOD-xxx\t\t\t\t\n" +
            "YUU\tYUU\t\t\t步兵\tYuzu\tYUU-xxx\t\t\t\t\n" +
            "EMP\tEMP\t\t\t步兵\tEMPIRE\tEMP-xxx\t\t\t\t\n" +
            "C0930-pla\tC0930-pla\t\t\t步兵\tC0930\tC0930-pla xxxx\t\t\t\t\n" +
            "C0930-gol \tC0930-gol \t\t\t步兵\tC0930\tC0930-gol xxxx\t\t\t\t\n" +
            "C0930-gitozuna\tC0930-gitozuna\t\t\t步兵\tC0930\tC0930-gitozuna xxxx\t\t\t\t\n" +
            "PB\tPB\t\t\t步兵\tPink Puncher\tPB-xxx\t\t\t\t\n" +
            "DRC\tDRC\t\t\t步兵\tCATCHEYE\tDRC-xxx\t\t\t\t\n" +
            "DRG\tDRG\t\t\t步兵\tCATCHEYE\tDRG-xxx\t\t\t\t\n" +
            "DSAM\tDSAM\t\t\t步兵\tSAMURAI PORN\tDSAM-x\t\t\t\t\n" +
            "EB\tEB\t\t\t步兵\tSAMURAI PORN\tEB-x\t\t\t\t\n" +
            "SMR\tSMR\t\t\t步兵\tSAMURAI PORN\tSMR-x\t\t\t\t\n" +
            "SP\tSP\t\t\t步兵\tSAMURAI PORN\tSP-x\t\t\t\t\n" +
            "xxx-av\txxx-av\t\t\t步兵\tXXX-AV\txxx-av xxxxx\t\t\t\t\n" +
            "muramura\tmuramura\t\t\t步兵\tMuraMura\tmuramura MMddyy-xxx\t\t\t\t\n" +
            "MKD\tMKD\t\t\t步兵\tRUBY人妻\tMKD-x\t\t\t\t\n" +
            "OPC\tOPC\t\t\t步兵\tOne Piece Entertainment\tOPC-xxx\t\t\t\t\n" +
            "Jukujo-Club\tJukujo-Club\t\t\t步兵\tJukujo-Club\tJukujo-Club-xxxx\t\t\t\t\n" +
            "PT\tPT\t\t\t步兵\tStudio Teriyaki\tPT-x\t\t\t\t\n" +
            "BT\tBT\t\t\t步兵\tStudio Teriyaki\tBT-x\t\t\t\t\n" +
            "CT\tCT\t\t\t步兵\tStudio Teriyaki\tCT-x\t\t\t\t\n" +
            "DT\tDT\t\t\t步兵\tStudio Teriyaki\tDT-x\t\t\t\t\n" +
            "SMJ\tSMJ\t\t\t步兵\tStudio Teriyaki\tSMJ-x\t\t\t\t\n" +
            "ST\tST\t\t\t步兵\tStudio Teriyaki\tST-x\t\t\t\t\n" +
            "mesubuta\tmesubuta\t\t\t步兵\tMesubuta\tmesubuta yyMMdd_xxx_01\t\t\t\t\n" +
            "AV9898\tAV9898\t\t\t步兵\tAV9898\tAV9898-xxxx\t\t\t\t\n" +
            "G-Queen\tG-Queen\t\t\t步兵\tG-Queen\tG-Queen-xxx\t\t\t\t\n" +
            "pacopacomama\tpacopacomama\t\t\t步兵\tPacopacomama\tpacopacomama-MMddyy\t\t\t\t\n" +
            "gach\tgach\t\t\t步兵\tGachinco\tgachixxx-HD\t\t\t\t\n" +
            "10musume\t10musume\t\t\t步兵\t10musume \t10musume-MMddyy_01\t\t\t\t\n" +
            "SSKJ\tSSKJ\t\t\t步兵\tSASUKE\tSSKJ-xxx \t\t\t\t\n" +
            "1000giri\t1000giri\t\t\t步兵\t1000giri\t1000giri-yyMMdd\t\t\t\t\n";


}

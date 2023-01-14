package com.simpleJavaProgram;

import lombok.Builder;

public class SqlDuel {

    public static void main(String[] args) {
//        将字段装换为Json字符串对象();
//        将Excel数据装换为Json字符串对象();
//        将Excel数据小写字段装换为Json字符串对象();
        将字段装换为CreateSql语句();
//        将驼峰装换为下划线();
//        将下划线转为驼峰();
    }

    private static void 将Excel数据小写字段装换为Json字符串对象() {
        String str = "fhSeries\tCaribbean\n" +
                "fhSysFanhao\t180119-587\n" +
                "fhPrimitiveFanhao\t011918-587\n" +
                "ypSubSeries\t未收录\n" +
                "ypFilmTitle\t僕の彼女が如月ジュリだったら ～主導権とチンコを握られている僕～\n" +
                "ypIssueYmd\t未收录\n" +
                "yyCoexistActressNum\t1\n" +
                "yyActressNo\t2022121001\n" +
                "yyActress\t如月ジュリ\n" +
                "yyCoexistActorNum\t1\n" +
                "yyActorNo\t一般男优\n" +
                "yyLadyboyNum\t0\n" +
                "yyLadyboyNo\t无\n" +
                "yyBeastType\t无\n" +
                "jqSceneType\t家庭\n" +
                "jqRoleType\t夫妻\n" +
                "jqStoryType\t夫妻性爱\n" +
                "analSexLv\t无\n" +
                "analEnemaLv\t无\n" +
                "analInjectSemenLv\t无\n" +
                "analCoexistPenisNum\t0\n" +
                "analEndoscopyYn\t否\n" +
                "xjInjectSemenLv\t内射\n" +
                "xjCoexistPenisNum\t1\n" +
                "xjEndoscopyVaginaYn\t否\n" +
                "kjOralSexLv\t自愿口交\n" +
                "kjMonthCoexistPenisNum\t9999\n" +
                "kjMouthEjaculateLv\t无\n" +
                "kjSwallowSemenLv\t无\n" +
                "tsTieLv\t无\n" +
                "tsWhiteTigerLv\t人工白虎\n" +
                "tsFaceEjaculateLv\t无\n" +
                "tsFemaleEjaculaYn\t否\n" +
                "tsDrindManUrineYn\t否\n" +
                "tsDrindWomanUrineYn\t否\n" +
                "msResume\t \n" +
                "msDetail\t \n" +
                "rcRecordTime\t \n" +
                "rcRecorder\twr\n" +
                "rcLastModifiedTime\t \n" +
                "rcLastModifier\twr\n" +
                "rcDataStatus\t1\n";

        System.out.println("{");
        String[] rows = str.split("\n");
        for (String row : rows) {
            String[] fields = row.split("\t");
            System.out.println("\t\""+ fields[0]+"\" : \"" + fields[1] + "\",");
        }
        System.out.println("}");

    }

    private static void 将下划线转为驼峰() {

        String str = "XL_SIMPLE\n" +
                "XL_FULL\n" +
                "NM_JP\n" +
                "NM_CN\n" +
                "FH_PATTERN\n" +
                "FH_RULER\n" +
                "GD_PRODUCER\n" +
                "GD_MOSAIC\n" +
                "GD_SUB_SERIES\n" +
                "GD_LOGO\n";
        String[] rows = str.split("\n");
        for (String row : rows) {
            String[] words = row.split("_");
            System.out.print(words[0].toLowerCase());
            for (int i = 1; i < words.length; i++) {
                System.out.print(words[i].substring(0,1) + words[i].substring(1).toLowerCase());
            }
            System.out.println("");
        }
    }

    private static void 将驼峰装换为下划线() {
        String str = "actressNo\n" +
                "nameStage\n" +
                "nameJpTrue\n" +
                "nameCn\n" +
                "nameEn\n" +
                "nameOther\n" +
                "birthYmd\n" +
                "birthCountry\n" +
                "birthPlace\n" +
                "yzAppearanceIndex\n" +
                "yzAppearanceType\n" +
                "scHeight\n" +
                "scFatLv\n" +
                "scWeight\n" +
                "scCup\n" +
                "scTitSizeLv\n" +
                "scBust\n" +
                "scLegsType\n" +
                "scLegsThickness\n" +
                "scHipType\n" +
                "scHipDistance\n" +
                "cdDebutYmd\n" +
                "cdRetireYmd\n";

        String[] rows = str.split("\n");
        for (String row : rows) {
            String s = row.replaceAll("[A-Z]", "_$0").toUpperCase();
            System.out.println(s);
        }


    }

    private static void 将字段装换为Json字符串对象() {
        String str = "SERIES\t系列\t由字典表维护, 系列表(D_SERIES)\n" +
                "PRIMITIVE_FANHAO\t原番号\t官方番号\n" +
                "SYS_FANHAO\t系统番号\t系统录入番号, 加勒比和一本道进行了时间的顺序化\n" +
                "FILM_TITLE\t影片名称\t\n" +
                "ACTRESS_NUM\t女优数\t0-没有,1-一个, 2-两个, N-大于两个\n" +
                "ACTRESS_NO\t女优编号\t关联表, 女演员表M_ACTRESS\n" +
                "ACTRESS\t女优\t\n" +
                "ACTOR_NUM\t男优数\t0-没有,1-一个, 2-两个, N-大于两个\n" +
                "ACTOR_NO\t男优\t由字典表维护, 男演员表(D_ACTOR)\n" +
                "LADYBOY_NUM\t人妖数\t0-没有,1-一个, 2-两个, N-大于两个\n" +
                "LADYBOY_NO\t人妖编号\t由字典表维护, 人妖表(D_LADYBOY)\n" +
                "BEAST_TYPE\t兽类\t狗,马,泥鳅,猪,蛇,其他\n" +
                "SCENE_TYPE\t场景\t家庭, 户外, 综艺, 囚禁, 专业A片\n" +
                "ROLE_TYPE\t角色\t妻子, 女儿, 老师, 下属, 上司, 性奴, 侦查官, 学生, 主人, 专业A片\n" +
                "STORY_TYPE\t剧情\t夫妻性爱, 轮乱, 强奸, 性虐, 兽交, 侦查官, 专业A片\n" +
                "ANAL_SEX_LV\t肛交级别\t0-无肛交, 1-1人肛交, N多人肛交\n" +
                "ENEMA_LV\t灌肠级别\t0-无灌肠, 1-简单灌肠, 2大量灌肠\n" +
                "ENDOSCOPY_ANAL_YN\t内窥肛门与否\tY-是, N-否\n" +
                "ENDOSCOPY_VAGINA_YN\t内窥阴道与否\tY-是, N-否\n" +
                "ORAL_SEX_LV\t口交级别\t0-无口交, 1-自愿口交, 2-强制口交, 3-深喉\n" +
                "TIE_LV\t捆绑级别\t0-无捆绑, 1-手脚捆绑, 2-全身捆绑, 3-支架捆绑\n" +
                "INJECT_SEMEN_LV\t阴道灌精级别\t0-无内射, 1-普通内射, 2-轮番内射, 3-轮番灌精\n" +
                "FACE_EJACULATE_LV\t颜射级别\t0-无颜射, 1-1人颜射, N-多人颜射\n" +
                "MOUTH_EJACULATE_LV\t口爆级别\t0-无口爆, 1-1人口爆, N-多人口爆\n" +
                "SWALLOW_SEMEN_LV\t吞精级别\t0-无吞精, 1-吞1人精, N-吞多人精\n" +
                "WHITE_TIGER_LV\t白虎级别\t0-非白虎, 1-人工白虎, 2-天然白虎\n" +
                "RECORDING_TIME\t收录时间\t\n" +
                "RECORDER\t收录人\t\n" +
                "LAST_MODIFIED_TIME\t最后修改时间\t\n" +
                "LAST_MODIFIER\t最后修改人\t\n";
        System.out.println("{");
        String[] rows = str.split("\n");
        for (String row : rows) {
            String[] fields = row.split("\t");
            String[] words = fields[0].split("_");
            System.out.print("\t\""+  words[0].toLowerCase());
            for (int i = 1; i < words.length; i++) {
                System.out.print(words[i].substring(0,1));
                System.out.print(words[i].substring(1).toLowerCase());
            }
            System.out.print("\" : \"" + fields[1]);
            if (fields.length > 2 && !"".equals(fields[2])) {
                System.out.print(": " + fields[2]);
            }
            System.out.println("\",");

        }
        System.out.println("}");

    }

    private static void 将字段装换为CreateSql语句() {
        String str = "XL_SIMPLE\t简称\t\n" +
                "XL_FULL\t全称\t\n" +
                "NM_JP\t日文名\t\n" +
                "NM_CN\t中文名\t\n" +
                "FH_PATTERN\t番号样式\t\n" +
                "FH_RULER\t番号规则\t\n" +
                "GD_PRODUCER\t厂商\t\n" +
                "GD_MOSAIC\t马赛克\t骑兵, 步兵\n" +
                "GD_SUB_SERIES\t子系列\t\n" +
                "GD_LOGO\t图标\t\n" +
                "MS_RESUME\t简述\t\n" +
                "MS_DETAIL\t详细\t\n" +
                "RC_RECORD_TIME\t收录时间\t\n" +
                "RC_RECORDER\t收录人\t\n" +
                "RC_LAST_MODIFIED_TIME\t最后修改时间\t\n" +
                "RC_LAST_MODIFIER\t最后修改人\t\n" +
                "RC_DATA_STATUS\t数据状态\t0-未生效, 1-正常, 2-不可用,9-废弃\n";

        String[] rows = str.split("\n");
        for (String row : rows) {
            String[] fields = row.split("\t");
            int i1 = 8 - fields[0].length()/4 ;
            System.out.print("\t" + fields[0]);
            for (int i = 0; i < i1; i++) {
                System.out.print("\t");
            }
            if (fields[0].endsWith("NUM")){
                System.out.print("\t\t\tINT" + "\t\t\t\t\tNOT NULL"+ "\t\tDEFAULT 9999\t\t\t");
            } else if (fields[0].equals("MS_RESUME")){
                System.out.print("\t\t\tVARCHAR(300)" + "\t\tNOT NULL"+ "\t\tDEFAULT ' '\t\t\t\t");
            } else if (fields[0].equals("MS_DETAIL")){
                System.out.print("\t\t\tVARCHAR(1000)" + "\t\tNOT NULL"+ "\t\tDEFAULT ' '\t\t\t\t");
            } else if (fields[0].endsWith("LV")){
                System.out.print("\t\t\tVARCHAR(30)" + "\t\t\tNOT NULL"+ "\t\tDEFAULT ' '\t\t\t\t");
            } else if (fields[0].endsWith("STATUS")){
                System.out.print("\t\t\tCHAR(1)" + "\t\t\t\tNOT NULL"+ "\t\tDEFAULT '0'\t\t\t\t");
            } else if (fields[0].endsWith("TYPE")){
                System.out.print("\t\t\tVARCHAR(30)" + "\t\t\tNOT NULL"+ "\t\tDEFAULT '未收录'\t\t\t");
            } else if (fields[0].endsWith("YMD")){
                System.out.print("\t\t\tCHAR(8)" + "\t\t\t\tNOT NULL"+ "\t\tDEFAULT '未收录'\t\t\t");
            } else if (fields[0].endsWith("TIME")){
                System.out.print("\t\t\tTIMESTAMP" + "\t\t\tNOT NULL"+ "\t\tDEFAULT CURRENT_TIMESTAMP");
            } else {
                System.out.print("\t\t\tVARCHAR(50)" + "\t\t\tNOT NULL"+ "\t\tDEFAULT '未收录'\t\t\t");
            }
            System.out.print( "\t\t\tCOMMENT '" + fields[1]);
            if (fields.length > 2 && !"".equals(fields[2])) {
                System.out.print(": " + fields[2]);
            }
            System.out.println("',");
        }
    }

    private static void 将Excel数据装换为Json字符串对象() {
        String str = "keyActressNo\t2022121001\n" +
                "nameStage\t如月ジュリ\n" +
                "nameJpTrue\t未收录\n" +
                "nameCn\t未收录\n" +
                "nameEn\t未收录\n" +
                "nameOther\t未收录\n" +
                "birthYmd\t未收录\n" +
                "birthCountry\t日本\n" +
                "birthPlace\t未收录\n" +
                "yzAppearanceIndex\t8\n" +
                "yzAppearanceType\t未收录\n" +
                "scHeight\t未收录\n" +
                "scFatLv\t未收录\n" +
                "scWeight\t未收录\n" +
                "scCup\tA\n" +
                "scTitSizeLv\t很小\n" +
                "scBust\t未收录\n" +
                "scLegsType\t微X\n" +
                "scLegsThickness\t较细\n" +
                "scHipType\t较囵\n" +
                "scHipDistance\t0.5\n" +
                "cdDebutYmd\t未收录\n" +
                "cdRetireYmd\t未收录\n" +
                "rcRecordTime\t20221210\n" +
                "rcRecorder\twr\n" +
                "rcLastModifiedTime\t20221210\n" +
                "rcLastModifier\twr\n" +
                "rcDataStatus\t1\n";

        System.out.println("{");
        String[] rows = str.split("\n");
        for (String row : rows) {
            String[] fields = row.split("\t");
            String[] words = fields[0].split("_");
            System.out.print("\t\""+  words[0].toLowerCase());
            for (int i = 1; i < words.length; i++) {
                System.out.print(words[i].substring(0,1));
                System.out.print(words[i].substring(1).toLowerCase());
            }
            System.out.println("\" : \"" + fields[1] + "\",");

        }
        System.out.println("}");
    }
}

package com.simpleJavaProgram;

import lombok.Builder;

public class SqlDuel {

    public static void main(String[] args) {
        //将字段装换为Json字符串对象();
//        将Excel数据装换为Json字符串对象();
        将Excel数据小写字段装换为Json字符串对象();
//        将字段装换为CreateSql语句();
        //将驼峰装换为下划线();
//        将下划线转为驼峰();
    }

    private static void 将Excel数据小写字段装换为Json字符串对象() {
        String str = "keyActressNo\t2022121001\n" +
                "nameStage\t如月ジュリ\n" +
                "nameJpTrue\t未收录\n" +
                "nameCn\t未收录\n" +
                "nameEn\t未收录\n" +
                "nameOther\t未收录\n" +
                "birthYmd\t未收录\n" +
                "birthCountry\t日本\n" +
                "birthPlace\t未收录\n" +
                "xmAppearanceIndex\t8\n" +
                "xmAppearanceType\t未收录\n" +
                "xmFaceType\t未收录\n" +
                "xmSkinColor\t未收录\n" +
                "xmLike\t未收录\n" +
                "qzCharacter\t未收录\n" +
                "txTallOrShort\t未收录\n" +
                "txFatOrThin\t未收录\n" +
                "txTitSize\t极小\n" +
                "txLegsType\t微X型\n" +
                "txLegsThickness\t较囵\n" +
                "txHipType\t较囵\n" +
                "txHipDistance\t0.5\n" +
                "hxColor\t未收录\n" +
                "hxType\t未收录\n" +
                "hxWhiteTiger\t未收录\n" +
                "scHeight\t未收录\n" +
                "scWeight\t未收录\n" +
                "scCup\t未收录\n" +
                "scBust\t未收录\n" +
                "cdDebutYmd\t未收录\n" +
                "cdDebutAge\t未收录\n" +
                "cdRetireYmd\t未收录\n" +
                "cdRetireAge\t未收录\n" +
                "cdPeriods\t未收录\n" +
                "rcRecordTime\t20221210\n" +
                "rcRecorder\twr\n" +
                "rcLastModifiedTime\t20221210\n" +
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

        String str = "KEY_ACTRESS_NO\n" +
                "NAME_STAGE\n" +
                "NAME_JP_TRUE\n" +
                "NAME_CN\n" +
                "NAME_EN\n" +
                "NAME_OTHER\n" +
                "BIRTH_YMD\n" +
                "BIRTH_COUNTRY\n" +
                "BIRTH_PLACE\n" +
                "XM_APPEARANCE_INDEX\n" +
                "XM_APPEARANCE_TYPE\n" +
                "XM_FACE_TYPE\n" +
                "XM_SKIN_COLOR\n" +
                "XM_LIKE\n" +
                "QZ_CHARACTER\n" +
                "TX_TALL_OR_SHORT\n" +
                "TX_FAT_OR_THIN\n" +
                "TX_TIT_SIZE\n" +
                "TX_LEGS_TYPE\n" +
                "TX_LEGS_THICKNESS\n" +
                "TX_HIP_TYPE\n" +
                "TX_HIP_DISTANCE\n" +
                "HX_COLOR\n" +
                "HX_TYPE\n" +
                "HX_WHITE_TIGER\n" +
                "SC_HEIGHT\n" +
                "SC_WEIGHT\n" +
                "SC_CUP\n" +
                "SC_BUST\n" +
                "CD_DEBUT_YMD\n" +
                "CD_DEBUT_AGE\n" +
                "CD_RETIRE_YMD\n" +
                "CD_RETIRE_AGE\n" +
                "CD_PERIODS\n" +
                "RC_RECORD_TIME\n" +
                "RC_RECORDER\n" +
                "RC_LAST_MODIFIED_TIME\n" +
                "RC_LAST_MODIFIER\n" +
                "RC_DATA_STATUS\n";
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
        String str = "KEY_ACTRESS_NO\t女优编号\t收录日期拼接2位数字\n" +
                "NAME_STAGE\t艺名\t\n" +
                "NAME_JP_TRUE\t日文真名\t\n" +
                "NAME_CN\t中文名\t\n" +
                "NAME_EN\t英文名\t\n" +
                "NAME_OTHER\t别名\t\n" +
                "BIRTH_YMD\t出生年月日\t\n" +
                "BIRTH_COUNTRY\t国家\t由字典表维护\n" +
                "BIRTH_PLACE\t出生地\t\n" +
                "XM_APPEARANCE_INDEX\t颜值\t1-4-差, 5-一般, 6-7-好看, 8-9-很好看, A-E-绝品, S-最爱\n" +
                "XM_APPEARANCE_TYPE\t相貌类型\t童颜, 御女, 熟妇\n" +
                "XM_FACE_TYPE\t脸型\t\n" +
                "XM_SKIN_COLOR\t肤色\t未收录, 黑, 黄, 白, 粉\n" +
                "XM_LIKE\t印象\t未收录, 无, 人名\n" +
                "QZ_CHARACTER\t性格\t未收录, 冷淡, 活泼\n" +
                "TX_TALL_OR_SHORT\t高低\t未收录, 很矮, 较矮, 中等, 较高, 很高\n" +
                "TX_FAT_OR_THIN\t胖瘦\t未收录, 很瘦, 较瘦, 中等, 较胖, 很胖\n" +
                "TX_TIT_SIZE\t奶子大小\t未收录, 极小, 小, 正常, 大, 巨大\n" +
                "TX_LEGS_TYPE\t腿型\t未收录, X型, 微X型, 筷子型, 微O型, O型\n" +
                "TX_LEGS_THICKNESS\t腿粗细\t未收录, 极细, 较细, 正常, 较粗, 极粗\n" +
                "TX_HIP_TYPE\t臀型\t未收录, 极囵, 较囵, 正常, 丰满, 肥\n" +
                "TX_HIP_DISTANCE\t胯距\t拳数\n" +
                "HX_COLOR\t颜色\t未收录, 黑色, 肤色, 粉色\n" +
                "HX_TYPE\t户型\t未收录, 一线天, 蝴蝶屄, 馒头屄\n" +
                "HX_WHITE_TIGER\t白虎\t未收录, 是, 否\n" +
                "SC_HEIGHT\t身高\tcm\n" +
                "SC_WEIGHT\t体重\tkg\n" +
                "SC_CUP\t杯罩\t未收录,A,B,C,D,E,F,G,H\n" +
                "SC_BUST\t三围\t\n" +
                "CD_DEBUT_YMD\t出道年月日\t\n" +
                "CD_DEBUT_AGE\t出道年龄\t\n" +
                "CD_RETIRE_YMD\t隐退年月日\t\n" +
                "CD_RETIRE_AGE\t隐退年龄\t\n" +
                "CD_PERIODS\t出道期间\t\n" +
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
            } else if (fields[0].endsWith("LV")){
                System.out.print("\t\t\tCHAR(1)" + "\t\t\t\tNOT NULL"+ "\t\tDEFAULT ' '\t\t\t\t");
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

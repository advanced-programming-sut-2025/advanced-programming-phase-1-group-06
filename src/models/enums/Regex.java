package models.enums;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum Regex {
    EXIT("^\\s*exit\\s+game\\s*"),
    REGISTER("^\\s*register\\s+-u\\s+(?<username>.+)\\s+-p\\s+(?<password>[^ ]+)\\s+((?<confirmation>[^ ]+)\\s+)?-n\\s+(?<nickname>.+)\\s+-e\\s+(?<email>.+)\\s+-g\\s+(?<gender>.+)\\s*$"),
    PICK_QUESTION("^\\s*pick\\s+question\\s+-q\\s+(?<questionNumber>\\d+)\\s+-a\\s+(?<answer>.+)\\s+-c\\s+(?<confirmation>.+)\\s*$"),
    LOGIN("^\\s*login\\s+-u\\s*(?<username>.+)\\s+-p\\s+(?<password>[^ ]+)(\\s+(?<stay>-stay-logged-in))?\\s*$"),
    FORGET("^\\s*forget\\s+password\\s+-u\\s+(?<username>.+)\\s*"),
    USERNAME("^[a-zA-Z0-9-]+$"),
    EMAIL("^([a-zA-Z0-9]([a-zA-Z0-9-._]*[a-zA-z0-9])?)@([a-zA-Z0-9]([a-zA-Z0-9-]*[a-zA-Z0-9])?)\\.([a-zA-Z0-9-]+[a-zA-Z0-9])$"),
    LOGOUT("^\\s*user\\s+logout\\s*$"),
    GO_TO_LOGIN_MENU("^\\s*go\\s+to\\s+login\\s+menu\\s*$"),
    GO_TO_REGISTER_MENU("^\\s*go\\s+to\\s+register\\s+menu\\s*$"),
    GO_TO_MENU("^\\s*go\\s+to\\s+(?<menuName>.+)\\s+menu\\s*$"),
    CHANGE_USERNAME("^\\s*change\\s+username\\s+-u\\s+(?<username>.+)\\s*$"),
    CHANGE_NICKNAME("^\\s*change\\s+nickname\\s+-n\\s+(?<nickname>.+)\\s*$"),
    CHANGE_EMAIL("^\\s*change\\+email\\+-n\\s+(?<email>.+)\\s*$"),
    CHANGE_PASSSWORD("^\\s*change\\s+password\\s+-p\\s+(?<password>.+)\\s+-o\\s+(?<oldPassword>.+)\\s*$"),
    BACK("^\\s*back\\s*$"),
    USER_INFO("^\\s*user\\s+info\\s*$"),
    STRONG_PASS("^(?=.{8,}$)" +        // at least 8 chars
            "(?=.*[a-z])" +        // at least one lowercase
            "(?=.*[A-Z])" +        // at least one uppercase
            "(?=.*\\d)"   +        // at least one digit
            "(?=.*[!#$%^&*()=+{}\\[\\]|\\/:;'\",<>?])" + // at least one special
            ".*$"),
    //    PASSWORDSPECIAL("?=.*[!#$%^&*()=+{}\\[\\]|\\/:;'\",<>?]"),
//    PASSWORDNUMBER("?=.[0-9]"),
//    PASSWORDLOWERCASE("?=.[a-z]"),
//    PASSWORDUPPERCASE("?=.[A-Z]"),
    ANSWER("^\\s*answer\\s+-a\\s+(?<answer>\\S+)\\s*$"),
    USER_LOGOUT("^\\s*user\\s+logout\\s*$"),
    CHANGE_PASSWORD("^\\s*change\\s+password\\s+-p\\s+(?<new_password>\\S+)\\s+-o\\s+(?<old_password>\\S+)\\s*$"),
    MENU_ENTER("^\\s*menu\\s+enter\\s+(?<menu_name>\\S+)\\s*$"),
    MENU_EXIT("^\\s*menu\\s+exit\\s*$"),
    SHOW_CURRENT_MENU("^\\s*show\\s+current\\s+menu\\s*$"),
    GAME_NEW("^\\s*game\\s+new\\s+-u\\s+(?<username1>\\S+)\\s+(?<username2>\\S+)\\s+(?<username3>\\S+)\\s*$"),
    GAME_MAP("^\\s*game\\s+map\\s+(?<map_number>\\d+)\\s*$"),
    LOAD_GAME("^\\s*load\\s+game\\s*$"),
    EXIT_GAME("^\\s*exit\\s+game\\s*$"),
    NEXT_TURN("^\\s*next\\s+turn\\s*$"),
    DATE("^\\s*date\\s*$"),
    TIME("^\\s*time\\s*$"),
    DATETIME("^\\s*datetime\\s*$"),
    DAY_OF_WEEK("^\\s*day\\s+of\\s+the\\s+week\\s*$"),
    CHEAT_ADVANCE_TIME("^\\s*cheat\\s+advance\\s+time\\s+(?<hours>\\d+)h\\s*$"),
    CHEAT_ADVANCE_DATE("^\\s*cheat\\s+advance\\s+date\\s+(?<days>\\d+)d\\s*$"),
    SEASON("^\\s*season\\s*$"),
    WEATHER("^\\s*weather\\s*$"),
    WEATHER_FORECAST("^\\s*weather\\s+forecast\\s*$"),
    WEATHER_SET("^\\s*cheat\\s+weather\\s+set\\s+(?<type>\\S+)\\s*$"),
    CHEAT_THOR("^\\s*cheat\\s+Thor\\s+-l\\s+(?<x>\\d+)\\s*,\\s*(?<y>\\d+)\\s*$"),
    GREENHOUSE_BUILD("^\\s*greenhouse\\s+build\\s*$"),
    GREENHOUSE_BUILDCHEAT("^\\s*greenhouse\\s+buildcheat\\s*$"),
    WALK("^\\s*walk\\s+-l\\s+(?<x>\\d+)\\s*,\\s*(?<y>\\d+)\\s*$"),
    PRINT_MAP("^\\s*print\\s+map\\s+-l\\s+(?<x>\\d+)\\s*,\\s*(?<y>\\d+)\\s+-s\\s+(?<size>\\d+)\\s*$"),
    HELP_READING_MAP("^\\s*help\\s+reading\\s+map\\s*$"),
    ENERGY_SHOW("^\\s*energy\\s+show\\s*$"),
    ENERGY_SET("^\\s*energy\\s+set\\s+-v\\s+(?<value>\\d+)\\s*$"),
    ENERGY_UNLIMITED("^\\s*energy\\s+unlimited\\s*$"),
    INVENTORY_SHOW("^\\s*inventory\\s+show\\s*$"),
    INVENTORY_TRASH("^\\s*inventory\\s+trash\\s+-i\\s+(?<item>\\S+)(\\s+-n\\s+(?<count>\\d+))?\\s*$"),
    TOOLS_EQUIP("^\\s*tools\\s+equip\\s+(?<toolName>\\S+)\\s*$"),
    TOOLS_SHOW_CURRENT("^\\s*tools\\s+show\\s+current\\s*$"),
    TOOLS_SHOW_AVAILABLE("^\\s*tools\\s+show\\s+available\\s*$"),
    TOOLS_UPGRADE("^\\s*tools\\s+upgrade\\s+(?<tool>\\S+)\\s*$"),
    TOOLS_USE("^\\s*tools\\s+use\\s+-d\\s+(?<direction>\\S+)\\s*$"),
    GIFT("^\\s*gift\\s+-u\\s+(?<username>\\S+)\\s+-i\\s+(?<item>\\S+)\\s+-a\\s+(?<amount>\\d+)\\s*$"),
    GIFT_LIST("^\\s*gift\\s+list\\s*$"),
    GIFT_RATE("^\\s*gift\\s+rate\\s+-i\\s+(?<gift_number>\\d+)\\s+-r\\s+(?<rate>\\d+)\\s*$"),
    GIFT_HISTORY("^\\s*gift\\s+history\\s+-u\\s+(?<username>\\S+)\\s*$"),
    HUG("^\\s*hug\\s+-u\\s+(?<username>\\S+)\\s*$"),
    FLOWER("^\\s*flower\\s+-u\\s+(?<username>\\S+)\\s*$"),
    SHOW_ALL_PRODUCTS("^\\s*show\\s+all\\s+products\\s*$"),
    SHOW_AVAILABLE_PRODUCTS("^\\s*show\\s+all\\s+available\\s+products\\s*$"),
    PURCHASE("^\\s*purchase\\s+(?<product>\\S+)\\s+-n\\s+(?<count>\\d+)\\s*$"),
    TERMINATE("^\\s*terminate\\s*$"),
    PLANT("^\\s*plant\\s+-s\\s+(?<seed>\\S+)\\s+-d\\s+(?<direction>\\S+)\\s*$"),
    SHOW_PLANT("^\\s*showplant\\s+-l\\s+(?<x>\\d+)\\s*,\\s*(?<y>\\d+)\\s*$"),
    CRAFTING_SHOW_RECIPES("^\\s*crafting\\s+show\\s+recipes\\s*$"),
    CRAFTING_CRAFT("^\\s*crafting\\s+craft\\s+(?<item_name>\\S+)\\s*$"),
    BUY_ANIMAL("^\\s*buy\\s+animal\\s+-a\\s+(?<animal>\\S+)\\s+-n\\s+(?<name>\\S+)\\s*$"),
    PET("^\\s*pet\\s+-n\\s+(?<name>\\S+)\\s*$"),
    CHEAT_SET_FRIENDSHIP("^\\s*cheat\\s+set\\s+friendship\\s+-n\\s+(?<animal_name>\\S+)\\s+-c\\s+(?<amount>\\d+)\\s*$"),
    ANIMALS("^\\s*animals\\s*$"),
    SHEPHERD_ANIMALS("^\\s*shepherd\\s+animals\\s+-n\\s+(?<animal_name>\\S+)\\s+-l\\s+(?<x>\\d+)\\s*,\\s*(?<y>\\d+)\\s*$"),
    FEED_HAY("^\\s*feed\\s+hay\\s+-n\\s+(?<animal_name>\\S+)\\s*$"),
    TRADE("^\\s*trade\\s+-u\\s+(?<username>\\S+)\\s+-t\\s+(?<type>\\S+)\\s+-i\\s+(?<item>\\S+)\\s+-a\\s+(?<amount>\\d+)(\\s+-p\\s+(?<price>\\d+))?(\\s+-ti\\s+(?<target_item>\\S+)\\s+-ta\\s+(?<target_amount>\\d+))?\\s*$"),
    TRADE_LIST("^\\s*trade\\s+list\\s*$"),
    TRADE_RESPONSE("^\\s*trade\\s+response\\s+(--accept|--reject)\\s+-i\\s+(?<id>\\d+)\\s*$"),
    TRADE_HISTORY("^\\s*trade\\s+history\\s*$"),
    FRIENDSHIP_NPC_LIST("^\\s*friendship\\s+NPC\\s+list\\s*$"),
    QUESTS_LIST("^\\s*quests\\s+list\\s*$"),
    QUESTS_FINISH("^\\s*quests\\s+finish\\s+-i\\s+(?<index>\\d+)\\s*$"),
    TEST("^\\s*test\\s*$"),
    CHEAT_CODE("^\\s*cheat\\s+code\\s*$"),
    ARTISAN_USE("^\\s*artisan\\s+use\\s+(?<artisan_name>\\S+)\\s+(?<item1_name>\\S+)\\s*$"),
    ARTISAN_GET("^\\s*artisan\\s+get\\s+(?<artisan_name>\\S+)\\s*$");


    ;

    private final Pattern pattern;

    Regex(String regex){
        pattern = Pattern.compile(regex);
    }

    public Matcher getMatcher(String input){
        Matcher matcher = this.pattern.matcher(input);
        if (matcher.matches()){
            return matcher;
        }
        return null;
    }
}

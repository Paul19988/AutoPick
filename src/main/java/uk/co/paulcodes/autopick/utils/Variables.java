package uk.co.paulcodes.autopick.utils;

public class Variables {

    private static String noperms;
    private static String reloadmsg;

    private static String prefixmsg;

    public static String PREFIX() {
        return prefixmsg;
    }

    public static void SET_PREFIX(String prefix) {
        prefixmsg = prefix;
    }

    public static String NO_PERMISSION(String permission) {
        return prefixmsg + noperms.replace("{permission}", permission);
    }

    public static void SET_NO_PERMISSION(String message) {
        noperms = message;
    }

    public static String RELOAD() {
        return prefixmsg + reloadmsg;
    }

    public static void SET_RELOAD(String message) {
        reloadmsg = message;
    }

}

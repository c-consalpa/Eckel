package IO.Prefs;

import java.util.prefs.Preferences;

public class PrefsDemo {
    public static void main(String[] args) {
        new Prefs().act();
    }
}


class Prefs {
    public void act() {
        Preferences prefs = Preferences.userNodeForPackage(this.getClass());
        System.out.println(prefs.get("mCustom1", "mCustom: default"));
        prefs.put("mCustom1", "isSet1");
        System.out.println(prefs.get("mCustom1", "mCustom: default"));


    }
}
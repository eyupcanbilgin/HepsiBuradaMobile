package org.Hepsiburada.base;

public class Locator {
    public static final String POP_UP = "//android.widget.ImageButton[@content-desc=\"Close\"]";
    public static final String NOTIFICATIONS = "//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_button\"]";
    public static final String MY_ACCOUNT_TAB = "//android.widget.FrameLayout[@content-desc=\"Hesabım\"]";
    public static final String LOGIN_BUTTON = "//android.widget.Button[@resource-id=\"com.pozitron.hepsiburada:id/button\" and @text=\"Giriş yap\"]";
    public static final String LOGIN_BUTTON_2 = "//android.widget.Button[@resource-id=\"btnLogin\"]";
    public static final String EMAIL_PHONE_TAB = "//android.widget.EditText[@resource-id=\"txtUserName\"]";
    public static final String PASSWORD_TAB = "//android.widget.EditText[@resource-id=\"txtPassword\"]";
    public static final String LOGIN_BUTTON_3 = "//android.widget.Button[@resource-id=\"btnEmailSelect\"]\n";
    public static final String WELCOME_MSG_OK = "//android.widget.Button[@resource-id=\"android:id/button1\"]";
    public static final String HOME_PAGE_BUTTON = "//android.widget.FrameLayout[@content-desc=\"Anasayfam\"]";
    public static final String SEARCH_TAB = "//android.widget.EditText[@resource-id=\"com.pozitron.hepsiburada:id/etSearchBox\"]";
    public static final String SEARCH_RESULT = "(//android.view.ViewGroup[@resource-id=\"com.pozitron.hepsiburada:id/search_suggestion\"])[2]";
    public static final String FILTER_BUTTON = "com.pozitron.hepsiburada:id/lytOptionBarFilters";
    public static final String GRAPHIC_CARD_BUTTON = "(//android.view.ViewGroup[@resource-id=\"com.pozitron.hepsiburada:id/lyt_filter_container\"])[6]";
    public static final String FILTER_APPLY = "com.pozitron.hepsiburada:id/btnFiltersApply";
    public static final String PRICE_FILTER = "//android.widget.TextView[@resource-id=\"com.pozitron.hepsiburada:id/tvFilterName\" and @text=\"Fiyat Aralığı\"]";
    public static final String SEE_FILTERED_PRODUCTS = "com.pozitron.hepsiburada:id/tvApplyFilterButton";
    public static final String ADD_CART = "com.pozitron.hepsiburada:id/product_detail_add_to_cart";
    public static final String GO_CART = "com.pozitron.hepsiburada:id/goBasketTxt";
    public static final String CART_DONE = "(//android.widget.CheckBox[@resource-id=\"selectedCheckBox\"])[1]";
    public static final String REMOVE_CART = "//android.view.View[@content-desc=\"Sepetten Çıkar\"]";
    public static final String DELETE_CART = "//android.widget.Button[@text=\"Sil\"]";
    public static final String SIGNOUT_ACC = "//android.widget.Button[@resource-id=\"com.pozitron.hepsiburada:id/button\"]";
    public static final String MY_ORDERS = "//android.view.ViewGroup[@content-desc=\"account_menu_0\"]";
}


package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;



public class profilAndLanguagePage extends BasePage{

    public profilAndLanguagePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "(//div[@data-testid='user-avatar'])[2]")
    WebElement avatar;

    @FindBy(css = "[data-testid='dropdown-profile-settings']")
    WebElement profilAyarlari;

    @FindBy(css = "[data-testid='dropdown-terms']")
    WebElement kullanimKosullari;

    @FindBy(css = "[data-testid='dropdown-upgrade']")
    WebElement yukselt;

    @FindBy(css = "[data-testid='dropdown-subscription']")
    WebElement abonelikBilgileriDropDown;

    @FindBy(css = "[data-testid='dropdown-billing']")
    WebElement faturaGecmisiDropDown;

    @FindBy(css = "[data-testid='dropdown-generation-history']")
    WebElement uretimGecmisiDropDown;

    @FindBy(xpath = "(//*[text()='İngilizce'])[1]")
    WebElement englishLanguage;

    @FindBy(xpath = "//span[text()='Abonelik Bilgileri']")
    WebElement hesap_abonelikBilgileri;

    @FindBy(xpath = "(//span[text()='Fatura Geçmişi'])[2]")
    WebElement hesap_faturaGecmisi;

    @FindBy(xpath = "(//span[text()='Üretim Geçmişi'])[2]")
    WebElement hesap_uretimGecmisi;

    @FindBy(xpath = "(//span[text()='Çıkış Yap'])")
    WebElement hesap_cikisYap;

    @FindBy(xpath = "(//a[text()='Abonelik'])")
    WebElement abonelik;

    @FindBy(xpath = "(//a[text()='Fatura Geçmişi'])")
    WebElement faturaGec;

    @FindBy(xpath = "(//a[text()='Üretim Geçmişi'])")
    WebElement uretimGec;

    @FindBy(xpath = "(//a[text()='Hesap'])")
    WebElement hesap;

    @FindBy(xpath = "(//button[text()='Planları Görüntüle'])")
    WebElement planlariYukselt;

    @FindBy(css = "[data-testid='button-terms']")
    WebElement hizmetKosullariButton;

    @FindBy(css = "[data-testid='button-contact-support']")
    WebElement destekIletisim;

    @FindBy(css = "[data-testid='button-delete-account']")
    WebElement AccountDelete;

    @FindBy(css = "[data-testid='button-confirm-delete']")
    WebElement confirmDelete;

    @FindBy(css = "[data-testid='button-cancel-delete']")
    WebElement cancel;

    @FindBy(xpath = "//h2[@class='text-base font-semibold text-gray-900' and text()='Profile']")
    WebElement profil;

    @FindBy(xpath = "//h2[@class='text-base font-semibold text-gray-900' and text()='Abonelik Bilgileri']")
    WebElement abonelikDogrulama;

    @FindBy(xpath = "//p[ text()='AiStager aboneliğinize ait faturalar ve makbuzlar']")
    WebElement makbuz;

    @FindBy(xpath = "//h2[@class='text-base font-semibold text-gray-900' and text()='Oluşturma Geçmişi']")
    WebElement olusturmaGecmisi;

    @FindBy(xpath = "//h2[@class='text-3xl font-bold text-gray-900' and text()='Hizmet Şartları']")
    WebElement hizmetDogrulama;

    @FindBy(xpath = "//h2[@class='text-3xl font-bold text-gray-900' and text()='Çerez Politikası']")
    WebElement cerezDogrulama;

    @FindBy(xpath = "//h2[@class='text-3xl font-bold text-gray-900' and text()='İptal Politikası']")
    WebElement iptalPolitikasi;

    @FindBy(xpath = "//h2[@class='text-3xl font-bold mb-4' and text()='İletişim Bilgileri']")
    WebElement iletisimBilgileri;

    @FindBy(xpath = "//button[@type='button' and text()='Hizmet Şartları']")
    WebElement hizmetSartlari;

    @FindBy(xpath = "//button[@type='button' and text()='Çerez Politikası']")
    WebElement cerezButton;

    @FindBy(xpath = "//button[@type='button' and text()='İptal']")
    WebElement iptal;

    @FindBy(xpath = "//button[@type='button' and text()='İletişim']")
    WebElement iletisimButton;

    @FindBy(css= "[data-testid='text-deletion-heading']")
    WebElement accountSuccess;

    @FindBy(xpath = "//*[text()='Ücretsiz Dene']")
    WebElement ucretsizDene;

    @FindBy(css= "[data-testid='hero-title']")
    WebElement planlarVeFiyatlandirma;

    @FindBy(xpath = "//h2[text()='Fatura Geçmişi']")
    WebElement faturaDogrulama;

    @FindBy(xpath = "//*[text()='Before and after magic']")
    WebElement languageDogrulama;

    @FindBy(css= "[data-testid='usage-button']:nth-of-type(1)")
    WebElement krediHover;

    @FindBy(css= "[data-testid='dropdown-sign-out']")
    WebElement cikisYap_Avatar;

    @FindBy(css = "[data-testid='heading-contact']")
    WebElement bizeUlasin;



    public void clickableButton(String name){
        switch (name.toLowerCase()){
            case "profil ayarları":{clickElement(profilAyarlari);} break;
            case "kullanım koşulları":{clickElement(kullanimKosullari);} break;
            case "çıkış yap":{clickElement(cikisYap_Avatar);} break;
            case "yükselt":{clickElement(yukselt);} break;
            case "abonelik bilgileri":{clickElement(abonelikBilgileriDropDown);} break;
            case "fatura geçmişi":{clickElement(faturaGecmisiDropDown);} break;
            case "üretim geçmişi":{clickElement(uretimGecmisiDropDown);} break;
            case "ingilizce": {clickElement(englishLanguage);} break;
            case "planları yükselt": {clickElement(planlariYukselt);} break;
            case "hizmet koşulları": {clickElement(hizmetKosullariButton);} break;
            case "destek ile iletişime geç": {clickElement(destekIletisim);} break;
            case "hesabı sil": {clickElement(AccountDelete);} break;
            case "hesabı sil onayla": {clickElement(confirmDelete);} break;
            case "iptal": {clickElement(cancel);} break;
        }
    }


    public void alanClickButton(String alan, String name){
        if (alan.toLowerCase().equalsIgnoreCase("sekme")){
            switch (name.toLowerCase()){
                case "abonelik": clickElement(abonelik); break;
                case "fatura geçmişi": clickElement(faturaGec); break;
                case "üretim geçmişi": clickElement(uretimGec); break;
                case "çerez politikası": clickElement(cerezButton); break;
                case "iptal": clickElement(iptal); break;
                case "iletişim": clickElement(iletisimButton); break;
            }
        } else if (alan.toLowerCase().equalsIgnoreCase("hesap")) {
            switch (name.toLowerCase()){
                case "abonelik bilgileri": clickElement(hesap_abonelikBilgileri); break;
                case "fatura geçmişi": clickElement(hesap_faturaGecmisi); break;
                case "üretim geçmişi": clickElement(hesap_uretimGecmisi); break;
                case "çıkış yap": clickElement(hesap_cikisYap); break;
            }
        }
    }


    public void hover(String name){
        if (name.toLowerCase().equalsIgnoreCase("avatar")){
            hoverElements(avatar);
        } else if (name.toLowerCase().equalsIgnoreCase("kredi")) {
            hoverElements(krediHover);
        }
    }

    public void veriyfContainsText(WebElement element,String value){
        Assert.assertTrue(element.getText().toLowerCase().contains(value.toLowerCase()),
                "Mesaj beklenen ifadeyi içermiyor! " +
                        "Gelen metin:"+ element.getText() + "\n"+ "Beklenen Metin:"+value);
    }

    public void verifySelectionHeadling(String value){
        WebElement element;

        switch (value.toLowerCase()){
            case "profil":
                element = profil;
                break;
            case "abonelik bilgileri":
                element = abonelikDogrulama;
                break;
            case "fatura geçmişi":
                element = faturaDogrulama;
                break;
            case "oluştuma geçmişi":
                element = olusturmaGecmisi;
                break;
            case "before and after magic":
                element = languageDogrulama;
                break;
            case "ücretsiz dene":
                element = ucretsizDene;
                break;
            case "planlar ve fiyatlandırma":
                element = planlarVeFiyatlandirma;
                break;
            case "hizmet şartları":
                element = hizmetDogrulama;
                break;
            case "bize ulaşın":
                element = bizeUlasin;
                break;
            case "hesabınız başarı ile silindi":
                element = accountSuccess;
                break;
            case "hesabı sil":
                element = AccountDelete;
                break;
            case "çerez politikası":
                element = cerezDogrulama;
                break;
            case "iptal politikası":
                element = iptalPolitikasi;
                break;
            case "iletişim bilgileri":
                element = iletisimBilgileri;
                break;
            default:
                throw new RuntimeException("Girdiğiniz isimde bir element bulunmamakta." + value);
        }

        veriyfContainsText(element,value);
    }




}
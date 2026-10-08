Feature: Profil ve Dil Ayarları

  Background:
    Given The user clicks the Log in button on the homepage.
    And The user clicks the cookie.
    When On the login page,enter a valid email and password.
      | testEmail    |
      | testPassword |
    And The user clicks the button.

  @Smoke
  Scenario: TR profil kısmı ayrıntılı testi
    Given kullanici "avatar" alanina hover yapar
    When kullanici dropdown menusundeki "Profil Ayarları" butonuna tiklar
    Then sayfada "Profil" metnini gormeli
    And kullanici "sekme" alanindaki "Abonelik" butonuna tiklar
    Then sayfada "Abonelik Bilgileri" metnini gormeli
    And kullanici "sekme" alanindaki "Fatura Geçmişi" butonuna tiklar
    Then sayfada "Fatura Geçmişi" metnini gormeli
    And kullanici "sekme" alanindaki "Üretim Geçmişi" butonuna tiklar
    Then sayfada "Oluşturma Geçmişi" metnini gormeli

  @Smoke
  Scenario: EN profil kısmı ayrıntılı testi
    Given kullanici dil secenegini "İngilizce" olarak secer
    Then sayfada "Before and after magic" metnini gormeli


  @Smoke
  Scenario: Hesap alanı test
    Given kullanici "avatar" alanina hover yapar
    When kullanici dropdown menusundeki "Profil Ayarları" butonuna tiklar
    And kullanici "hesap" alanindaki "Abonelik Bilgileri" butonuna tiklar
    Then sayfada "Abonelik Bilgileri" metnini gormeli
    And kullanici geriye tiklayarak geri doner
    And kullanici "hesap" alanindaki "Fatura Geçmişi" butonuna tiklar
    Then sayfada "Fatura Geçmişi" metnini gormeli
    And kullanici "hesap" alanindaki "Üretim Geçmişi" butonuna tiklar
    Then sayfada "Oluşturma Geçmişi" metnini gormeli
    And kullanici "hesap" alanindaki "Çıkış Yap" butonuna tiklar
    Then sayfada "Ücretsiz Dene" metnini gormeli


  @Smoke
  Scenario: Abonelik ve hesap yönetimi testi
    Given kullanici "avatar" alanina hover yapar
    When kullanici dropdown menusundeki "Profil Ayarları" butonuna tiklar
    And kullanici "sekme" alanindaki "Abonelik" butonuna tiklar
    When kullanici "Planları yükselt" butonuna tiklar
    Then sayfada "Planlar ve Fiyatlandırma" metnini gormeli
    And kullanici geriye tiklayarak geri doner
    And kullanici "Hizmet Koşulları" butonuna tiklar
    Then sayfada "Hizmet Şartları" metnini gormeli
    And kullanici geriye tiklayarak geri doner
    And kullanici "Destek ile İletişime Geç" butonuna tiklar
    Then sayfada "Bize Ulaşın" metnini gormeli
    And kullanici "Hesabı Sil" butonuna tiklar
    And kullanici modal uzerindeki "Hesabı Sil Onayla" butonuna tiklar
    Then sayfada "Hesabınız başarı ile silindi" metnini gormeli
    And kullanici modal uzerindeki "İptal" butonuna tiklar
    Then sayfada "Hesabı Sil" metnini gormeli

  @Smoke
  Scenario: Hizmet Sartlari Alanı
    Given kullanici "avatar" alanina hover yapar
    When kullanici dropdown menusundeki "Kullanım Koşulları" butonuna tiklar
    Then sayfada "Hizmet Şartları" metnini gormeli
    And kullanici "sekme" alanindaki "Çerez Politikası" butonuna tiklar
    Then sayfada "Çerez Politikası" metnini gormeli
    And kullanici "sekme" alanindaki "İptal" butonuna tiklar
    Then sayfada "İptal Politikası" metnini gormeli
    And kullanici "sekme" alanindaki "İletişim" butonuna tiklar
    Then sayfada "İletişim Bilgileri" metnini gormeli


  @Smoke
  Scenario: Kredi dropdown menu test
    Given kullanici "kredi" alanina hover yapar
    When kullanici dropdown menusundeki "Yükselt" butonuna tiklar
    Then sayfada "Planlar ve Fiyatlandırma" metnini gormeli
    And kullanici "kredi" alanina hover yapar
    And kullanici dropdown menusundeki "Abonelik Bilgileri" butonuna tiklar
    Then sayfada "Abonelik Bilgileri" metnini gormeli
    And kullanici "kredi" alanina hover yapar
    And kullanici dropdown menusundeki "Fatura Geçmişi" butonuna tiklar
    Then sayfada "Fatura Geçmişi" metnini gormeli
    And kullanici "kredi" alanina hover yapar
    And kullanici dropdown menusundeki "Üretim Geçmişi" butonuna tiklar
    Then sayfada "Oluşturma Geçmişi" metnini gormeli

  @Smoke
  Scenario: Avatar alanı Cıkış Yap test
    Given kullanici "avatar" alanina hover yapar
    When kullanici dropdown menusundeki "çıkış Yap" butonuna tiklar
    Then sayfada "Ücretsiz Dene" metnini gormeli
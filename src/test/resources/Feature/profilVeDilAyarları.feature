Feature: Profil ve Dil Ayarları

  Scenario: TR profil kısmı ayrıntılı testi
    Given kullanici profil kismina hover yapar
    When kullanici profil ayarlari butonuna tiklar
    Then kullanici profil metinin gormeli
    And kullanici Abonelik butonuna tiklar
    Then Abonelik bilgileri metni gorunmeli
    And  kullanici planlari goruntule butonuna tiklar
    Then planlar ve fiyatlandirma metni gorunmeli
    And kullanici back butonuna tıklar ve hesap ayarlari kismina doner
    And kullanici hizmet kosullari butonuna tiklar
    Then hizmet sartlari metni gorunmeli
    And kullanıcı back butonuna tıklar ve hesap ayarları kismina doner
    And kullanici destek ile iletişime gec butonuna tiklar
    Then bize ulasin metni gorunmeli
    And kullanici hesabi sil butonuna tiklar
    And kullanici acilan alandaki hesabi sil butonuna tiklar
    Then Hesabiniz başariyla silindi metni gorunmeli
    And kullanici acilan alandaki iptal  butonuna tiklar
    Then acilan alan kapatilmali
    And kullanici fatura gecmisi butonuna tiklar
    Then fatura gecmisi metnini gormeli
    And kullanici uretim gecmisi butonuna tiklar butonuna tiklar
    Then olusturma gecmisi metnini gormeli






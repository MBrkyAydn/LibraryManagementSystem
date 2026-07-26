# Library Management System

Java ile geliştirilmiş konsol tabanlı bir kütüphane yönetim sistemi. Proje, nesne yönelimli programlama prensiplerini uygulamak amacıyla geliştirilmiştir. Kitap ve üye yönetimi, ödünç alma/iade işlemleri, Generic yapılar, Stream API ve Exception Handling konularını içermektedir.

## Özellikler

### Kitap İşlemleri

- Kitap ekleme
- Kitap silme
- ID ile kitap arama
- Başlığa göre kitap arama
- Tüm kitapları listeleme

### Üye İşlemleri

- Üye ekleme
- Üye silme
- ID ile üye arama
- Tüm üyeleri listeleme

### Ödünç İşlemleri

- Kitap ödünç verme
- Kitap iade etme
- Üyenin ödünç aldığı kitapları görüntüleme

### Stream API

- Başlığa göre kitap arama
- Kullanılabilir kitapları filtreleme
- Kitapları sıralama
- Count, AnyMatch ve FindFirst işlemleri

### Exception Handling

- BookNotFoundException
- MemberNotFoundException
- BookAlreadyExistException
- MemberAlreadyExistException
- BookAlreadyBorrowedException

## Kullanılan Teknolojiler

- Java
- Object-Oriented Programming (OOP)
- Collections Framework
- Generic Interface
- Stream API
- Exception Handling

## Proje Yapısı

```text
src
├── model
├── exception
├── InputHelper
├── Library.java
└── Main.java
```

## Öğrenilen Konular

- Object-Oriented Programming
- Encapsulation
- Composition
- Generic Interface Tasarımı
- Java Collections
- Stream API
- Exception Handling
- Konsol tabanlı menü tasarımı

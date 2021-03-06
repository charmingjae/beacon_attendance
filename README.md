# Automatic checking access system using [Beacon](https://ko.wikipedia.org/wiki/%EB%B9%84%EC%BD%98)
> 2021 - 1ํ๊ธฐ  

<br/>

## ๐ค Team : " ๋ณถ์๋ฐฅ์ ์ธํ๊ฐ "  
๐จโ๐ (C)[์ฐจ๋ฏผ์ฌ](https://github.com/charmingjae)  
๐จโ๐ [๊น์๋น](https://github.com/eungbin)  
๐จโ๐ [๋ฐ๊ท๋ฏผ](https://github.com/mareepark)  



<br/>

## ๐จ๐ปโ๐ป Overview  
COVID-19 ์ฌํ๋ก ์ธํด ์ ๋ถ์์๋ ์์์ ๊ณผ ๊ฐ์ ์ฌ์์ฅ์ ๋ฐฉ๋ฌธ ์ QR์ฝ๋๋ฅผ ์ด์ฉํ์ฌ ๋ฐฉ๋ฌธ์์ ๊ธฐ๋ก์ ๋ณด๊ดํ๋ค.  
QR์ฝ๋ ๋ฐฉ์์ QR์ฝ๋๋ฅผ ๋ฐ๊ธํ๋ ํ์ฌ๋ก๋ถํฐ 1ํ์ฑ ์ฝ๋๋ฅผ ๋ฐ๊ธ๋ฐ์ ์ฒดํฌํ๋๋ฐ QR์ฝ๋๋ฅผ ๋ฐ๋๋ฐ๊น์ง์ ๊ณผ์ ์ด ์ค๋ ๊ฑธ๋ฆฐ๋ค.  
๋ฐ๋ผ์ ์ด๋ฌํ ๋นํจ์จ์ ์ธ ๋ถ๋ถ์ ๊ฐ์ ํ๊ธฐ ์ํด ๋น์ฝ์ ํ์ฉํ์ฌ ์ฌ์์ฅ ๋ฐฉ๋ฌธ ์ ์๋์ ์ผ๋ก ์ถ์ ์ฌ๋ถ๋ฅผ ์ฒดํฌํ๋๋ก ์์คํ์ ๊ตฌํํ๊ณ ์ ํ๋ค.  

<br/>

## ๐ง Tech

OS(Operating System) :
```java
Android ( SDK Version : 28 )
```

Database : 
> โ ๏ธ Need [google-services.json](https://firebase.google.com/docs/android/setup?hl=ko)
```
Firebase
```

Beacon :
```
Minew beacon E7
```

<br/>


## ๐โโ๏ธ Getting Started
> ๋ณธ ํ๋ก์ ํธ๋ H/W(Beacon)๊ณผ Android ๊ธฐ๊ธฐ ๊ฐ ํต์ ์ ์ด์ฉํ ํ๋ก์ ํธ๋ก ๊ตฌ๋ ์ Beacon๊ณผ Android OS๋ฅผ ๊ธฐ๋ฐ์ผ๋ก ํ App์ ๊ตฌ๋ํ  ์ ์๋ ๊ธฐ๊ธฐ๊ฐ ํ์ํฉ๋๋ค.  

1. Clone
~~~bash
git clone https://github.com/charmingjae/beacon_attendance
~~~  

2. Turn on the device Bluetooth  

3. Run

<br/> 

## ๐ฆ Setting

> Dependencies  

~~~java
dependencies {
    implementation 'androidx.appcompat:appcompat:1.2.0'
    implementation 'com.google.android.material:material:1.3.0'
    implementation 'androidx.constraintlayout:constraintlayout:2.0.4'
    implementation 'com.google.firebase:firebase-database:19.7.0'
    implementation 'com.google.firebase:firebase-auth:20.0.4'
    implementation 'com.android.support:support-v4:28.0.0'
    implementation 'com.android.support:appcompat-v7:28.0.0'
    testImplementation 'junit:junit:4.+'
    androidTestImplementation 'androidx.test.ext:junit:1.1.2'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.3.0'
    implementation fileTree(include: ['*.jar'], dir: 'libs')
    implementation files('libs/minewBeaconAdmin.jar')
    implementation 'com.android.support:recyclerview-v7:28.0.0'
    compile 'com.android.support:recyclerview-v7:28.0.0'
}
~~~

<br/>  

> Android config

~~~java
compileSdkVersion 28
buildToolsVersion "30.0.3"
minSdkVersion 18
targetSdkVersion 26
~~~

<br/>  

## ๐ Comment  

> Need HardWare 'Beacon' to check rssi between beacon and device

๋ณธ ํ๋ก์ ํธ๋ ๋ชจ๋ฐ์ผ ๋๋ฐ์ด์ค์ Beacon๊ฐ์ ์ ํธ ์ธ๊ธฐ๋ฅผ ๋ฐํ์ผ๋ก ๊ตฌํ ๋ ์ดํ๋ฆฌ์ผ์ด์์๋๋ค. ๋ฐ๋ผ์ ์ํํ ์ดํ๋ฆฌ์ผ์ด์์ ๊ตฌ๋๊ณผ ์ฌ์ฉ์ ์ํด [๋น์ฝ](https://ko.wikipedia.org/wiki/%EB%B9%84%EC%BD%98)์ด ํ์ํฉ๋๋ค.  
๋ณธ ํ๋ก์ ํธ์์ ์ฌ์ฉ ๋ ๋น์ฝ์ ๊ตฌ๋งค ์ ๋ณด๋ [์ฌ๊ธฐ](http://m.nowwin.co.kr/product/%EB%B9%84%EC%BD%98-ibeacon-%EB%B8%94%EB%A3%A8%ED%88%AC%EC%8A%A4-beacon-i9-%EB%B9%84%ED%8F%B0-beafon/74/)์์ ํ์ธํ์ค ์ ์์ต๋๋ค.
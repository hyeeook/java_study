# 객체지향 프로그래밍
## 객체지향언어의 특징
1) 코드의 재사용성이 높다.
   - 새로운 코드를 작성할 때 기존의 코드를 이용하여 쉽게 작성할 수 있다.
2) 코드의 관리가 용이하다.
   - 코드간의 관계를 이용해서 적은 노력으로 쉽게 코드를 변경할 수 있다.
3) 신뢰성이 높은 프로그래밍을 가능하게 한다.
   - 제어자와 메서드를 이용해서 데이터를 보호하고 올바른 값을 유지하도록 하며, 코드의 중복을 제거하여 코드의 불일치로 인한 오동작을 방지할 수 있다.

---

## 클래스와 객체
- 클래스의 정의 : 객체를 정의해 놓은 것.
- 클래스의 용도 : 객체를 생성하는데 사용.
- 객체의 정의 : 실제로 존재하는 것. 사물 또는 개념.
- 객체의 용도 : 객체가 가지고 있는 기능과 속성에 따라 다름.
- 유형의 객체 : 책상, 의자, 자동차, TV와 같은 사물.
- 무형의 객체 : 수학공식, 프로그램 에러와 같은 논리나 개념.

클래스|객체
---|---
제품 설계도|제품
TV 설계도|TV
붕어빵 기계|붕어빵

---

## 객체의 구성요소(멤버) - 속성과 기능
- 속성(property) : 크기, 길이, 높이, 색상, 볼륨, 채널 등
- 기능(function) : 켜기, 끄기, 볼륨 높이기, 볼륨 낮추기, 채널 변경하기 등

속성|기능
---|---
멤버변수(variable)|메서드(method)
int channel|channelUp() {}

```java
class Tv
{
	String color;	//색상 속성
	boolean power;	//전원상태 속성
	int channel;	//채널 속성
	
	//전원on/off 기능
	void power()
	{
		this.power = !this.power;
	}
	
	//채널변경 기능
	void channelUp()
	{
		++this.channel;
	}
	
	//채널변경 기능
	void channelDown()
	{
		--this.channel;
	}
}
```

---

## 객체와 인스턴스
- 인스턴스화(instantiate) : 클래스로부터 객체를 만드는 과정.
- 인스턴스(instance) : 클래스로부터 만들어진 객체.
결국 객체와 인스턴스는 같은 의미이지만, 객체는 모든 인스턴스를 대표하는 포괄적인 의미를 갖고 있으며, 인스턴스는 어떤 클래스로부터 만들어진 것인지를 보다 강조하는 의미를 갖고 있다.

---

## 객체의 생성과 사용
```java
public class ObjectCreationAndUsage
{
	public static void main(String[] args)
	{
		//1) Tv클래스 타입의 참조변수 tv를 선언.
		//2) 메모리에 참조변수 tv를 위한 공간이 마련됨.
		//아직 인스턴스가 생성되지 않았으므로 이 참조변수로 할 수 있는 것은 아무것도 없음.
		Tv tv;
		
		//1) 연산자 new에 의해 Tv클래스의 인스턴스가 메모리의 빈 공간('0x100'로 가정)에 생성됨.
		//2) 멤버변수는 각 자료형에 해당하는 기본값으로 초기화 됨.
		//3) 대입연산자에 의해 생성된 객체의 주소값(0x100)이 참조변수 tv에 저장됨(참조변수 tv에는 주소값 '0x100'이 저장된 상태).
		//이제 참조변수 tv로 Tv인스턴스에 접근 가능.
		//인스턴스를 다루기 위해서는 반드시 참조변수가 필요.
		tv = new Tv();
		
		//참조변수 tv에 저장된 주소(0x100)에 있는 인스턴스의 멤버변수 channel에 7을 저장.
		tv.channel = 7;
		
		//참조변수 tv가 참조하고 있는 Tv인스턴스의 channelDown() 메서드를 호출.
		tv.channelDown();
		
		//참조변수 tv가 참조하고 있는 Tv인스턴스의 멤버변수 channel에 저장되어 있는 값을 출력.
		System.out.println("현재 채널은 " + tv.channel + " 입니다.");
	}

}

class Tv
{
	String color;	//색상 속성
	boolean power;	//전원상태 속성
	int channel;	//채널 속성
	
	//전원on/off 기능
	void power()
	{
		this.power = !this.power;
	}
	
	//채널변경 기능
	void channelUp()
	{
		++this.channel;
	}
	
	//채널변경 기능
	void channelDown()
	{
		--this.channel;
	}
}
```
- 참조변수 - 인스턴스 : TV리모컨 - TV
- 인스턴스는 참조변수를 통해서만 다룰 수 있으며, 참조변수의 타입은 인스턴스의 타입과 일치해야 함.
- 같은 클래스로부터 생성되었을지라도 각 인스턴스의 속성(멤버변수)은 서로 다른 값을 유지할 수 있으며, 메서드의 내용은 모든 인스턴스에 대해 동일함.

---

## 객체배열
- 객체 역시 배열로 다룰 수 있음.
- 객체 배열 안에는 객체가 저장되는 것이 아니라 객체의 주소가 저장됨.
- 객체 배열은 참조변수들을 하나로 묶은 참조변수 배열인 것.
- `Tv tv1, tv2, tv3;` → `Tv[] tvArr = new Tv[3];`

```java
//1) Tv클래스 배열의 참조변수 tvArr를 선언.
//2) 메모리에 참조변수 tvArr를 위한 공간이 마련됨.
//아직 인스턴스가 생성되지 않았으므로 이 참조변수로 할 수 있는 것은 아무것도 없음.
Tv[] tvArr;

//1) 3개의 Tv클래스 인스턴스가 연달아 저장될 공간이 메모리의 빈 공간('0x100'로 가정)에 생성됨.
//2) 배열의 각 요소는 참조변수의 기본값인 null로 자동 초기화 됨.
//3) 대입연산자에 의해 생성된 배열의 주소값(0x100)이 참조변수 tvArr에 저장됨(참조변수 tvArr에는 주소값 '0x100'이 저장된 상태).
//객체를 다루기 위한 참조변수들만 만들어진, 아직 인스턴스가 생성 및 저장되지는 않은 상태.
//참조변수 tvArr에는 3개의 객체, 정확히는 객체의 주소를 저장할 수 있음.
//아직 인스턴스가 생성되지 않았으므로 이 참조변수로 할 수 있는 것은 아무것도 없음.
tvArr = new Tv[3];

//객체를 생성해서 배열의 각 요소에 저장.
tvArr[0] = new Tv();
tvArr[1] = new Tv();
tvArr[2] = new Tv();
```

---

## 클래스의 정의
### 데이터와 함수의 결합
1) 변수 : 하나의 데이터를 저장할 수 있는 공간.
2) 배열 : 같은 종류의 여러 데이터를 하나의 집합으로 저장할 수 있는 공간.
3) 구조체 : 서로 관련된 여러 데이터를 종류에 관계없이 하나의 집합으로 저장할 수 있는 공간.
4) 클래스 : 데이터와 함수의 결합(구조체 + 함수)

### 사용자 정의 타입
시간 표현하기(1)
```java
int hour;
int minute;
float second;
```
시간 표현하기(2) - 3개의 시간 다루기
```java
int hour1, hour2, hour3;
int minute1, minute2, minute3;
float second1, second2, second3;
```
시간 표현하기(3) - 더 많은 시간 다루기
```java
int[] hour = new int[10];
int[] minute = new int[10];
float[] second = new float[10];
```
시간 표현하기(4) - 관련있는 데이터 묶기
```java
class Time
{
  int hour;
  int minute;
  float second;
}
```

비객체지향적 코드(1)
```java
int hour1, hour2, hour3;
int minute1, minute2, minute3;
float second1, second2, second3;
```
객체지향적 코드(1)
```java
Time time1 = new Time();
Time time2 = new Time();
Time time3 = new Time();
```
비객체지향적 코드(2)
```java
int[] hour = new int[3];
int[] minute = new int[3];
float[] second = new float[3];
```
객체지향적 코드(2)
```java
Time time = new Time[3];
time[0] = new Time();
time[1] = new Time();
time[2] = new Time();
```

- 객체지향적 코드를 통해 시, 분, 초가 하나의 단위로 묶여서 다루어지기 때문에 다른 시간 데이터와 섞이는 일은 없어짐.
- 그러나 시간 데이터에는 다음과 같은 추가적인 제약조건이 있음.
  1) 시, 분, 초는 모두 0보다 크거나 같아야 함.
  2) 시의 범위는 0~23, 분과 초의 범위는 0~59.
- 위와 같은 조건들이 반영되어야 보다 정확한 데이터를 유지할 수 있음.
```java
class Time
{
	private int hour;
	private int minute;
	private float second;
	
	public void setHour(int h)
	{
		if(!(0<=h && h<24))
		{
			return;
		}
		
		this.hour = h;
	}
}
```
- 제어자를 통해 변수의 값을 직접 변경하지 못하게 하고, 대신 메서드를 통해 값을 변경하도록 작성함.

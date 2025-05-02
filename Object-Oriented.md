# 객체지향 프로그래밍
---
## 객체지향언어의 특징
1) 코드의 재사용성이 높음.
   - 새로운 코드를 작성할 때 기존의 코드를 이용하여 쉽게 작성 가능.
2) 코드의 관리가 용이.
   - 코드간의 관계를 이용해서 적은 노력으로 쉽게 코드를 변경 가능.
3) 신뢰성이 높은 프로그래밍 가능.
   - 제어자와 메서드를 이용해서 데이터를 보호하고 올바른 값을 유지하도록 하며, 코드의 중복을 제거하여 코드의 불일치로 인한 오동작을 방지.

---

## 클래스와 객체
구분|클래스|객체
---|---|---
정의|객체를 정의해 놓은 것|실제로 존재하는 것 / 사물 또는 개념
용도|객체를 생성하는데 사용|객체가 가지고 있는 기능과 속성에 따라 다름
기능|제품 설계도|제품
예시|TV 설계도|TV

- 유형의 객체 : 책상, 의자, 자동차, TV와 같은 사물.
- 무형의 객체 : 수학공식, 프로그램 에러와 같은 논리나 개념.

---

## 객체의 구성요소(멤버) - 속성과 기능
구분|속성(property)|기능(function)
---|---|---
구현방법|멤버변수(variable)|메서드(method)
구현코드|int channel|channelUp() {}
예시|크기, 길이, 높이, 색상, 볼륨, 채널 등|켜기, 끄기, 볼륨 높이기, 볼륨 낮추기, 채널 변경하기 등

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
결국 객체와 인스턴스는 같은 의미이지만, 객체는 모든 인스턴스를 대표하는 포괄적인 의미를 갖고 있으며, 인스턴스는 어떤 클래스로부터 만들어진 것인지를 보다 강조하는 의미를 갖음.

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
		
		//3) 연산자 new에 의해 Tv클래스의 인스턴스가 메모리의 빈 공간('0x100'로 가정)에 생성됨.
		//4) 멤버변수는 각 자료형에 해당하는 기본값으로 초기화 됨.
		//5) 대입연산자에 의해 생성된 객체의 주소값(0x100)이 참조변수 tv에 저장됨(참조변수 tv에는 주소값 '0x100'이 저장된 상태).
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

//3) 3개의 Tv클래스 인스턴스가 연달아 저장될 공간이 메모리의 빈 공간('0x100'로 가정)에 생성됨.
//4) 배열의 각 요소는 참조변수의 기본값인 null로 자동 초기화 됨.
//5) 대입연산자에 의해 생성된 배열의 주소값(0x100)이 참조변수 tvArr에 저장됨(참조변수 tvArr에는 주소값 '0x100'이 저장된 상태).
//객체를 다루기 위한 참조변수들만 만들어진, 아직 인스턴스가 생성 및 저장되지는 않은 상태.
//참조변수 tvArr에 저장된 주소에서 시작하여 총 3개의 객체, 정확히는 객체의 주소를 저장할 수 있고 각 객체에는 인덱스로 접근할 수 있음.
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
#### 객체지향으로 시간 표현하기
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

#### 비객체지향적 코드와 객체지향적 코드
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

#### 정확한 시간 데이터를 위한 기능 추가
- 객체지향적 코드를 통해 시, 분, 초가 하나의 단위로 묶여서 다루어지기 때문에 다른 시간 데이터와 섞이는 일은 없어짐.
- 그러나 시간 데이터에는 다음과 같은 추가적인 제약조건이 있음.
  1) 시, 분, 초는 모두 0보다 크거나 같아야 함.
  2) 시의 범위는 0-23, 분과 초의 범위는 0-59.
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

---

## 선언 위치에 따른 변수 종류
```java
class Variables
{
	//클래스 영역 시작
	
	int iv;		//인스턴스 변수
	static int cv;	//클래스 변수
	
	void method(int lv1)	//파라미터로 선언된 변수로 지역 변수
	{
		//메서드 영역 시작
		
		int lv2 = 0;	//지역 변수
		
		//메서드 영역 종료
	}
	
	//클래스 영역 종료
}
```

1) 클래스 변수(class variable)
   - 멤버변수 중 'static'이 붙은 변수.
   - 클래스 영역에 선언.
   - 모든 인스턴스가 공통된 저장공간(변수)을 공유하므로 모든 인스턴스가 동일한 값을 가지게 됨.
   - 한 클래스의 모든 인스턴스들이 공통적인 값을 유지해야하는 속성의 경우, 클래스 변수로 선언.
   - 인스턴스를 생성하지 않고 언제라도 바로 사용할 수 있음.
2) 인스턴스 변수(instance variable)
   - 멤버변수 중 'static'이 붙이 않은 변수
   - 클래스 영역에 선언.
   - 인스턴스를 생성할 때 만들어짐.
   - 인스턴스 변수의 값을 읽거나 저장하기 위해서는 반드시 먼저 인스턴스를 생성해야 함.
   - 인스턴스마다 별도의 저장공간(변수)을 가지므로 서로 다른 인스턴스는 서로 다른 값을 가질 수 있음.
   - 인스턴스마다 고유한 상태를 유지해야하는 속성의 경우, 인스턴스 변수로 선언. 
3) 지역 변수(local variable)
   - 멤버변수를 제외한 나머지 변수.
   - 메서드 내에 선언되어 메서드 내에서만 사용 가능.
   - 메서드가 종료되면 소멸되어 사용 불가.
   - for문, while문의 블럭{} 내에 선언된 지역변수는 지역변수가 선언된 블럭{} 내에서만 사용 가능하며, 블럭{}을 벗어나면 소멸되어 사용 불가.

변수의 종류|선언위치|생성시기
---|---|---
클래스 변수(class variable)|클래스 영역|클래스가 메모리에 올라갈 때
인스턴스 변수(instance variable)|클래스 영역|인스턴스가 생성되었을 때
지역 변수(local variable)|클래스 영역 이외의 영역(메서드, 생성자, 초기화 블럭 내부)|변수 선언문이 수행되었을 때

---

## 클래스 변수와 인스턴스 변수
트럼프 카드에는 무늬, 숫자, 폭, 높이와 같은 속성이 존재함.

구분|개별속성|공통속성
---|---|---
특징|카드마다 다른 값|모든 카드에 동일한 값
변경사항 적용 범위|한 카드의 값을 변경하면 변경한 카드에만 적용됨|한 카드의 값을 변경하면 모든 카드에 적용됨
예시|무늬, 숫자|폭, 높이
구현방법|인스턴스 변수|클래스 변수

```java

public class Variables
{
	public static void main(String[] args)
	{
		//클래스 변수는 객체 생성 없이 사용 가능
		System.out.println("Card.WIDTH : " + Card.WIDTH);	//Card.WIDTH : 100
		System.out.println("Card.HEIGHT : " + Card.HEIGHT);	//Card.HEIGHT : 250
		System.out.println();
		
		//인스턴스 변수는 객체 생성 후 사용 가능
		Card card1 = new Card();
		card1.kind = "Heart";
		card1.number = 7;
		
		Card card2 = new Card();
		card2.kind = "Spade";
		card2.number = 3;
		
		//한 인스턴스의 클래스 변수를 변경하면 동일한 클래스로 생성된 모든 인스턴스에 대해 변경사항이 적용됨
		card1.WIDTH = 50;
		card1.HEIGHT = 100;
		
		System.out.println("card1.kind : " + card1.kind);	//card1.kind : Heart
		System.out.println("card1.number : " + card1.number);	//card1.number : 7
		System.out.println("card1.WIDTH : " + card1.WIDTH);	//card1.WIDTH : 50
		System.out.println("card1.HEIGHT : " + card1.HEIGHT);	//card1.HEIGHT : 100
		System.out.println();
		System.out.println("card2.kind : " + card2.kind);	//card2.kind : Spade
		System.out.println("card2.number : " + card2.number);	//card2.number : 3
		System.out.println("card2.WIDTH : " + card2.WIDTH);	//card2.WIDTH : 50, card1의 WIDTH 값을 변경했으나 card2의 WIDTH 값도 변경됨
		System.out.println("card2.HEIGHT : " + card2.HEIGHT);	//card2.HEIGHT : 100, card1의 HEIGHT 값을 변경했으나 card2의 HEIGHT 값도 변경됨
	}
}

class Card
{
	//개별속성
	String kind;	//무늬
	int number;	//숫자
	
	//공통속성
	static int WIDTH = 100;	 //폭
	static int HEIGHT = 250; //높이
}
```

인스턴스 변수는 인스턴스가 생성될 때마다 생성되므로 인스턴스마다 각기 다른 값을 유지할 수 있지만, 클래스 변수는 모든 인스턴스가 하나의 저장공간을 공유하므로, 항상 공통된 값을 갖게 됨. 위 코드에서 Card.WIDTH, card1.WIDTH, card2.WIDTH는 모두 같은 저장공간을 참조하므로 셋 중 무엇을 변경해도 동일한 값을 갖게 됨.

---

## 기본형(primitive type) 매개변수
변수의 값을 읽기만 가능(read only).

```java
public class PrimitiveParameter
{
	public static void main(String[] args)
	{
		//(1) 새로운 객체 data 생성. data 객체의 주소는 '0x100'으로 가정함.
		Data data = new Data();
		
		//(2) data 객체의 멤버변수 x의 값을 10으로 저장.
		data.x = 10;
		System.out.println("main().x = " + data.x);	//main().x = 10
		
		//(3) change() 메서드가 호출되면서 'data.x' 값(10)이 change() 메서드의 매개변수 x에 복사됨.
		change(data.x);
		
		//(5) change() 메서드가 종료되면서 매개변수 x는 스택에서 제거됨.
		System.out.println("After change(data.x)");	//After change(data.x)
		System.out.println("main().x = " + data.x);	//main().x = 10
	}
	
	static void change(int x)
	{
		//(4) change() 메서드에서 x의 값을 1000으로 변경.
		x = 1000;
		System.out.println("change().x = " + x);	//change().x = 1000
	}
}

class Data
{
	int x;
}
```

위 코드에서 'data.x'의 값은 변경된 것이 아니라, change() 메서드의 매개변수 x의 값이 변경된 것.
원본이 아닌 복사본이 변경된 것이라 원본에는 아무런 영향을 미치지 못함.
이처럼 기본형 매개변수는 변수에 저장된 값을 읽을 수만 있을 뿐 변경할 수는 없음.

---

## 참조형(reference type) 매개변수
인스턴스의 주소가 복사되므로 변수의 값을 읽고 변경하기 가능(read & write).

```java
public class ReferenceParameter
{
	public static void main(String[] args)
	{
		//(1) 새로운 객체 data 생성. data 객체의 주소는 '0x100'으로 가정함.
		Data data = new Data();
		
		//(2) data 객체의 멤버변수 x의 값을 10으로 저장.
		data.x = 10;
		System.out.println("main().x = " + data.x);		//main().x = 10
		
		//(3) change() 메서드가 호출되면서 참조변수 data의 값(주소, 0x100)이 매개변수 data에 복사됨에 따라 이제 매개변수 data에 저장된 주소값으로 x에 접근이 가능함.
		change(data);
		
		//(5) change() 메서드가 종료되면서 매개변수 data는 스택에서 제거됨.
		System.out.println("After change(data)");		//After change(data)
		System.out.println("main().x = " + data.x);		//main().x = 1000
	}
	
	static void change(Data data)
	{
		//(4) change() 메서드에서 매개변수 data(주소, 0x100)로 x의 값을 1000으로 변경.
		data.x = 1000;
		System.out.println("change().x = " + data.x);	//change().x = 1000
	}
}

class Data
{
	int x;
}
```

기본형 매개변수와 달리, change() 메서드의 매개변수를 참조형으로 선언했기 때문에, x의 값이 아닌 변수 data의 주소가 매개변수 data에 복사됨.
이제 main() 메서드의 참조변수 data와 change() 메서드의 매개변수 data는 같은 객체를 가리키게 됨.
그래서 매개변수 data로 x의 값을 읽는 것과 변경하는 것이 모두 가능함.

---

## 참조형 반환타입
매개변수만이 아니라 반환타입도 참조형이 될 수 있음.
반환타입이 참조형이라는 것은 반환하는 값의 타입이 참조형이라는 것인데, 모든 참조형 타입의 값은 '객체의 주소'이므로 그저 주소값이 반환되는 것.

```java
public class ReferenceReturn
{
	public static void main(String[] args)
	{
		//(1) 새로운 객체 data1 생성. data1 객체의 주소는 '0x100'으로 가정함.
		Data data1 = new Data();
		data1.x = 10;
		
		//(2) copy() 메서드가 호출되면서 참조변수 data1의 값(주소, 0x100)이 매개변수 data에 복사됨에 따라 이제 매개변수 data에 저장된 주소값으로 data1.x에 접근이 가능함.
		Data data2 = copy(data1);	//(6) copy() 메서드에서 반환된 주소값 '0x200'이 참조변수 data2에 저장됨.
		
		//(7) copy() 메서드가 종료되면서 매개변수 data는 스택에서 제거됨.
		System.out.println("data1.x = " + data1.x);	//data1.x = 10
		System.out.println("data2.x = " + data2.x);	//data2.x = 10
	}
	
	static Data copy(Data data)
	{
		//(3) 새로운 객체 tmp 생성. tmp 객체의 주소는 '0x200'으로 가정함.
		Data tmp = new Data();
		
		//(4) data.x의 값을 tmp.x에 복사
		tmp.x = data.x;
		
		//(5) 복사한 객체의 주소 '0x200'를 반환
		return tmp;
	}
}

class Data
{
	int x;
}
```

---

## 클래스 메서드와 인스턴스 메서드
- 메서드 앞에 static이 붙어 있으면 클래스 메서드, 붙어 있지 않으면 인스턴스 메서드(변수와 동일).
- 클래스 메서드는 객체를 생성하지 않고도 호출 가능, 인스턴스 메서드는 반드시 객체를 생성한 후에 호출 가능(변수와 동일).
- 클래스는 '데이터(변수)와 데이터에 관련된 메서드의 집합'이므로, 같은 클래스 내에 있는 메서드와 멤버변수는 아주 밀접한 관계가 있음.
- 인스턴스 메서드는 인스턴스 변수와 관련된 작업을 하는, 즉 메서드의 작업을 수행하는데 인스턴스 변수를 필요로 하는 메서드. 그런데 인스턴스 변수는 인스턴스(객체)를 생성해야만 만들어지므로 인스턴스 메서드 역시 인스턴스를 생성해야만 호출할 수 있음.
- 반면에 메서드 중에서 인스턴스와 관계없는(인스턴스 변수나 인스턴스 메서드를 사용하지 않는) 메서드를 클래스 메서드로 정의함.
- 클래스 메서드로 정의하는 기준
  - 메서드의 작업을 수행하는데 인스턴스와 관계 없는(인스턴스 변수나 인스턴스 메서드를 사용하지 않는) 경우.
- 인스턴스 메서드로 정의하는 기준
  - 메서드의 작업을 수행하는데 인스턴스 변수가 필요한 경우.
- static을 붙이는 기준
  - 클래스 설계 시에 멤버변수 중 모든 인스턴스에 공통으로 사용하는 경우.
    > 생성된 각 인스턴스는 서로 독립적이기 때문에 각 인스턴스의 변수(iv)는 서로 다른 값을 유지함.
    > 그러나 모든 인스턴스에서 같은 값이 유지되어야 하는 변수는 클래스 변수로 정의해야 함.
  - 클래스 변수는 인스턴스를 생성하지 않아도 사용 가능.
    > 클래스 변수는 클래스가 메모리에 올라갈 때 이미 자동으로 생성되기 때문.
  - 클래스 메서드는 인스턴스 변수 사용 불가.
    > 인스턴스 변수는 인스턴스가 반드시 존재해야만 사용 가능.
    > 클래스 메서드는 인스턴스 생성 없이 호출이 가능하므로 클래스 메서드가 호출되었을 때 인스턴스가 존재하지 않을 수도 있어서 인스턴스 변수 사용이 금지됨.
    > 반면, 인스턴스 멤버가 존재한다는 것은 클래스 멤버가 이미 메모리에 존재한다는 것을 의미하므로, 인스턴스 멤버에서는 클래스 멤버들을 언제나 사용 가능.
  - 메서드 내에서 인스턴스 멤버를 사용하지 않는 경우
    > 메서드 작업 내용 중에서 인스턴스 멤버를 필요로 한다면, static을 붙일 수 없음.
    > 반대로 인스턴스 멤버를 필요로 하지 않는다면 static을 붙일 것에 대해 고려해야 함.
    > 클래스 메서드를 사용하면 인스턴스 메서드를 사용할 때보다 성능이 향상됨.
    > 인스턴스 메서드는 실행 시에 호출되어야 하는 메서드를 찾는 과정이 추가적으로 필요하기 때문에, static을 붙인 클래스 메서드보다 시간이 더 소요됨.
  - 클래스의 멤버변수 중 모든 인스턴스에 공통된 값을 유지해야 하는 것이 있는지 보고 있으면 static을 붙임.
  - 작성한 메서드 중 인스턴스 멤버를 사용하지 않는 메서드에 static을 붙일 것 고려.

```java
class MyMath
{
	long a, b;
	
	//인스턴스 메서드 - a, b는 인스턴스 변수
	long add()
	{
		return this.a + this.b;
	}
	
	long subtract()
	{
		return this.a - this.b;
	}
	
	long multiply()
	{
		return this.a * this.b;
	}
	
	double divide()
	{
		return this.a / this.b;
	}
	
	//-----------------------------------
	
	//클래스 메서드 - a, b는 지역변수
	static long add(long a, long b)
	{
		return a + b;
	}
	
	static long subtract(long a, long b)
	{
		return a - b;
	}
	
	static long multiply(long a, long b)
	{
		return a * b;
	}
	
	static double divide(long a, long b)
	{
		return a / b;
	}
}

public class StaticAndInstanceMethod
{
	public static void main(String[] args)
	{
		//인스턴스 생성 없이 클래스 메서드 호출
		System.out.println(MyMath.add(200L, 100L));		//300
		System.out.println(MyMath.subtract(200L, 100L));	//100
		System.out.println(MyMath.multiply(200L, 100L));	//20000
		System.out.println(MyMath.divide(200L, 100L));		//2.0
		
		System.out.println();
		
		MyMath myMath = new MyMath();
		myMath.a = 200L;
		myMath.b = 100L;
		
		//인스턴스 생성 후 인스턴스 메서드 호출
		System.out.println(myMath.add());	//300
		System.out.println(myMath.subtract());	//100
		System.out.println(myMath.multiply());	//20000
		System.out.println(myMath.divide());	//2.0
	}
}
```

---

## 변수 및 메서드 간의 호출과 참조
- 같은 클래스에 속한 멤버들 간에는 별도의 인스턴스를 생성하지 않고도 서로 참조 또는 호출이 가능.
- 단, 클래스 멤버가 인스턴스 멤버를 참조 또는 호출하고자 하는 경우에는 인스턴스를 생성하야 함.
  - 인스턴스 멤버가 존재하는 시점에 클래스 멤버는 항상 존재하지만, 클래스 멤버가 존재하는 시점에 인스턴스 멤버가 존재하지 않을 수도 있기 때문.

```java
public class MethodCallAndReference
{
	int iv;				//인스턴스 변수
	static int cv;			//클래스 변수
	
	void instanceMethod1() {}	//인스턴스 메서드
	static void classMethod1() {}	//클래스 메서드
	
	void instanceMethod2()		//인스턴스 메서드
	{
		instanceMethod1();	//인스턴스 메서드 호출 - 정상
		classMethod1();		//클래스 메서드 호출 - 정상
		
		System.out.println(iv);	//인스턴스 변수 사용 - 정상
		System.out.println(cv);	//클래스 변수 사용 - 정상
	}
	
	static void classMethod2()	//클래스 메서드
	{
		instanceMethod1();	//인스턴스 메서드 호출 - 오류, 클래스 메서드에서는 인스턴스 메서드 호출 불가
		classMethod1();		//클래스 메서드 호출 - 정상
		
		System.out.println(iv);	//인스턴스 변수 사용 - 오류, 클래스 메서드에서는 인스턴스 변수 사용 불가
		System.out.println(cv);	//클래스 변수 사용 - 정상
	}
}
```

---

## 오버로딩(overloading)
- 메서드도 변수와 마찬가지로 같은 클래스 내에서 서로 구별될 수 있어야 하기 때문에 각기 다른 이름을 가져야 함.
- 그러나 자바에서는 한 클래스 내에 이미 사용하려는 이름과 같은 이름을 가진 메서드가 있더라도 매개변수의 개수 또는 타입이 다르면, 같은 이름을 사용해서 메서드를 정의할 수 있음.
- 이처럼 한 클래스 내에 같은 이름의 메서드를 여러 개 정의하는 것을 '메서드 오버로딩(overloading)'이라고 함.
- 메서드 오버로딩의 성립 조건
  1) 메서드 이름이 같아야 함.
  2) 매개변수의 개수 또는 타입이 달라야 함.
  3) 반환 타입은 관계 없음.
- 비록 메서드의 이름이 같더라도 매개변수가 다르면 서로 구별될 수 있기 때문에 오버로딩이 가능한 것.
- 'System.out.println()'이 오버로딩의 대표적인 예.

<오버로딩의 잘못된 예1>
```java
int add(int a, int b) {return a + b;}
int add(int x, int y) {return x + y;}
```

<오버로딩의 잘못된 예2>
```java
int add(int a, int b) {return a + b;}
long add(int a, int b) {return (long)(a + b);}
```

<오버로딩의 올바른 예>
```java
long add(int a, long b) {return a + b;}
long add(long a, int b) {return a + b;}
```

<오버로딩의 올바른 예>에서와 같이 단지 매개변수의 순서만 다르게 하여 오버로딩을 구현하면, 사용자가 매개변수의 순서를 외우지 않아도 된다는 장점이 있으나, 오히려 단점이 될 수 있음.
- `add(3, 3L)`과 같이 메서드를 호출하면 첫 번째 메서드가, `add(3L, 3)`과 같이 메서드를 호출하면 두 번째 메서드가 호출됨.
- 그러나 `add(3, 3)`과 같이 메서드를 호출하면 두 메서드 중에서 어느 메서드가 호출된 것인지 알 수 없기 때문에 메서드를 호출하는 곳에서 컴파일 에러가 발생.

---

## 생성자(constructor)
- 인스턴스가 생성될 때 호출되는 '인스턴스(변수) 초기화 메서드'.
- 인스턴스 변수의 초기화 작업에 주로 사용.
- 인스턴스 생성 시에 실행되어야 하는 작업을 위해서도 사용.
- 메서드와 동일하게 클래스 내에 선언.
- 구조도 메서드와 유사하지만 리턴값이 없음.
- 리턴값이 없으나 리턴값이 없다는 의미의 키워드 'void'를 사용하지는 않고, 리턴 타입 자체를 생략.
  > 생성자도 메서드이기 때문에 리턴값이 없다는 의미의 'void'를 붙여야 하지만, 모든 생성자가 리턴값이 없으므로 'void'를 생략할 수 있게 한 것.
- 생성자의 조건
  1) 생성자의 이름은 클래스의 이름과 동일해야 함.
  2) 생성자는 리턴값이 없음.
- 생성자도 오버로딩이 가능하므로 하나의 클래스에 여러 개의 생성자가 존재할 수 있음.
- 연산자 new가 인스턴스를 생성하는 것이지 생성자가 인스턴스를 생성하는 것은 아님.

```java
클래스이름(타입변수명, 타입변수명, ... )
{
	//인스턴스 생성 시 수행될 코드
	//주로 인스턴스 변수의 초기화 코드
}

class Point
{
	int x, y;
	
	Point()			//매개변수가 없는 생성자
	{
		this.x = 0;
		this.y = 0;
	}
	
	Point(int x, int y)	//매개변수가 있는 생성자
	{
		this.x = x;
		this.y = y;
	}
}
```

---

## 기본 생성자(default constructor)
- 모든 클래스에는 반드시 하나 이상의 생성자가 정의되어 있어야 함.
- 컴파일 시에 소스파일(*.java)의 클래스에 생성자가 하나도 정의되지 않은 경우는 컴파일러가 자동으로 기본 생성자(`클래스이름() {}`)를 추가하여 컴파일 함.
- 컴파일 시에 소스파일(*.java)의 클래스에 생성자가 하나라도 정의되어 있는 경우는 컴파일러가 기본 생성자를 추가하지 않으므로 반드시 기본 생성자를 개발자가 직접 추가해야 함(추가하지 않으면 기본 생성자를 사용하지 못함).
- 컴파일러가 자동으로 추가하는 기본 생성자는 매개변수도 없고 아무런 내용도 없는 간단한 생성자.
- 클래스의 '접근 제어자(Access Modifier)'가 'public'인 경우, 기본 생성자로 `public 클래스이름() {}`이 추가됨.

```java
public class DefaultConstructor
{
	public static void main(String[] args)
	{
		Data1 d1 = new Data1();
		Data2 d2 = new Data2();
		Data3 d3 = new Data3();	//compile error 발생, 이미 개발자가 선언한 다른 생성자가 있기 때문에 컴파일러가 자동으로 기본 생성자를 추가하지 않음
		
		//error message :
		//Exception in thread "main" java.lang.Error: Unresolved compilation problem:
		//	The constructor Data3() is undefined
		//
		//	at DefaultConstructor.main(DefaultConstructor.java:7)
	}
}

class Data1
{
	int value;
}

class Data2
{
	int value;
	
	Data2()		//기본 생성자
	{
	
	}
}

class Data3
{
	int value;
	
	Data3(int x)	//개발자가 직접 추가한 매개변수가 있는 생성자
	{
		this.value = x;
	}
}
```

---

## 매개변수가 있는 생성자
- 생성자도 메서드처럼 매개변수를 선언하여 호출 시에 값을 넘겨받아서 인스턴스의 초기화 작업에 사용할 수 있음.
- 매개변수가 있는 생성자를 사용하는 경우, 인스턴스를 생성하는 동시에 원하는 값으로 초기화 가능.

```java
public class ConstructorWithParameter
{
	public static void main(String[] args)
	{
		Car car1 = new Car();
		Car car2 = new Car();				//인스턴스 생성 후 각 필드에 접근하여 초기화
		Car car3 = new Car("green", "manual", 4);	//생성자로 인스턴스 초기화
		
		car2.color = "red";
		car2.gearType = "auto";
		car2.door = 2;
		
		System.out.println(car1.toString());		//Car [color=null, gearType=null, door=0]
		System.out.println(car2.toString());		//Car [color=red, gearType=auto, door=2]
		System.out.println(car3.toString());		//Car [color=green, gearType=manual, door=4]
	}
}

class Car
{
	String color;						//자동차 색상
	String gearType;					//변속기 종류 - auto(자동), manual(수동)
	int door;						//문의 개수
	
	Car() {}						//기본 생성자
	
	Car(String color, String gearType, int door)		//매개변수가 있는 생성자
	{
		this.color = color;
		this.gearType = gearType;
		this.door = door;
	}
	
	@Override
	public String toString() {
		return "Car [color=" + color + ", gearType=" + gearType + ", door=" + door + "]";
	}
}
```

---

## 생성자에서 다른 생성자 호출하기 - this()
- 같은 클래스의 멤버들 간에 서로 호출할 수 있는 것처럼 생성자 간에도 서로 호출이 가능함.
- 생성자에서 다른 생성자를 호출하기 위한 조건
  1) 생성자의 이름으로 클래스 이름 대신 'this'를 사용.
  2) 한 생성자에서 다른 생성자를 호출할 때는 반드시 첫 줄에서만 호출이 가능.
     > 생성자 내에서 초기화 작업 도중에 다른 생성자를 호출하게 되면, 호출된 다른 생성자 내에서도 멤버변수들의 값을 초기화할 것이므로 다른 생성자를 호출하기 이전의 초기화 작업이 무의미해 질 수 있음.

```java
class Car
{
	String color;					//자동차 색상
	String gearType;				//변속기 종류 - auto(자동), manual(수동)
	int door;					//문의 개수
	
	Car()						//기본 생성자
	{
		this("white", "auto", 4);
	}
	
	Car(String color)				//매개변수가 있는 생성자
	{
		this(color, "auto", 4);
	}
	
	Car(String color, String gearType, int door)	//매개변수가 있는 생성자
	{
		this.color = color;
		this.gearType = gearType;
		this.door = door;
	}
	
	@Override
	public String toString() {
		return "Car [color=" + color + ", gearType=" + gearType + ", door=" + door + "]";
	}
}
```

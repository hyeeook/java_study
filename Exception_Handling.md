# Exception
---
## 프로그램 오류
- 프로그램이 실행 중 어떤 원인에 의해 오작동을 하거나 비정상적으로 종료되는 경우, 이러한 결과를 초래하는 원인.
- Checked Exception
    - 컴파일 에러(compile-time error).
    - Exception 하위 RuntimeException 외 클래스.
    - 컴파일 타임에 반드시 처리해야 함.
    - 사용자의 실수로 발생할 수 있음.
    - 코드로 해결 가능(FileNotFoundException의 경우, 파일이 없음을 알리고 파일을 생성하는 방식으로 처리 가능).
- Unchecked Exception
    - 런타임 에러(runtime error).
    - Exception 하위 RuntimeException의 자손.
    - 개발자가 직접 처리하지 않아도 됨.
    - 대부분 개발자의 실수로 발생.
    - 코드로 해결 가능(FileNotFoundException의 경우, 파일이 없음을 알리고 파일을 생성하는 방식으로 처리 가능).
- Error
    - 근본적인 문제를 코드로 해결 불가(OutOfMemoryError의 경우, 메모리가 부족해서 발생한 에러로 코드로 메모리의 크기를 조정하거나 할 수는 없기 때문에 try-catch문으로 묶어도 의미가 없음).
    - 시스템적인 문제.
    - JVM에서 발생.

<상속계층도> <br>
java.lang.Throwable <br>
│ <br>
├── java.lang.Exception(예외 - 해결 가능) <br>
│   ├── java.io.IOException(Checked Exception) <br>
│   ├── java.sql.SQLException(Checked Exception) <br>
│   ├── java.lang.InterruptedException(Checked Exception) <br>
│   ├── java.lang.ReflectiveOperationException(Checked Exception) <br>
│   ├── javax.naming.NamingException(Checked Exception) <br>
│   ├── java.lang.RuntimeException(Unchecked Exception) <br>
│   │   ├── java.lang.NullPointerException <br>
│   │   ├── java.lang.ArrayIndexOutOfBoundsException <br>
│   │   ├── java.lang.IllegalArgumentException <br>
│   │   ├── java.lang.ClassCastException <br>
│   │   ├── java.lang.ArithmeticException <br>
│   │   ├── java.util.NoSuchElementException <br>
│ <br>
├── java.lang.Error(오류 - 해결 불가능) <br>
│   ├── java.lang.OutOfMemoryError(Unchecked Exception) <br>
│   ├── java.lang.StackOverflowError(Unchecked Exception) <br>
│   ├── java.lang.VirtualMachineError(Unchecked Exception) <br>
│   ├── java.lang.ThreadDeath(Unchecked Exception) <br>
│   ├── java.lang.AssertionError(Unchecked Exception) <br>

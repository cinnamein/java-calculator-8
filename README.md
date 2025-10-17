# java-calculator-precourse [![Java CI with Gradle](https://github.com/cinnamein/java-calculator-8/actions/workflows/gradle-ci.yml/badge.svg?branch=cinnamein)](https://github.com/cinnamein/java-calculator-8/actions/workflows/gradle-ci.yml)

> 본 프로젝트는 우아한테크코스 8기 프리코스 과정의 1차 과제로, 주어진 요구사항에 따라 문자열 덧셈 계산기를 구현하는 것을 목표로 합니다.

## 유의사항

- 실행 환경: JDK 21
- 시작점: `Application.main()` 메소드
- 외부 라이브러리: `camp.nextstep.edu.missionutils` 에서 제공하는 API 외 사용 금지
- 사용자 입력: `camp.nextstep.edu.missionutils.Console.readLine()` 사용
- 종료: `System.exit()` 호출 금지
- 코드 스타일: [**우아한테크코스** Java Style Guide](https://github.com/woowacourse/woowacourse-docs/tree/main/styleguide/java) 준수
- 커밋 메시지: [AngularJS Git Commit Message Conventions](https://gist.github.com/stephenparish/9941e89d80e2bc58a153) 준수
- build.gradle 파일 수정 금지
- 제공된 파일, 패키지 이름 수정 및 이동 금지

## 요구사항 명세서

### 구분자를 기준으로 문자열 분리

- 쉼표(,)와 콜론(:) 및 사용자가 별도로 지정한 커스텀 구분자를 기준으로 문자열을 분리한다.
- 구분자들이 혼용된 경우에도 정상적으로 문자열을 분리한다.
- 구분자로 시작하거나 끝나는 경우 예외를 발생시킨다. 
- 구분자가 연속되어 빈 값이 생기는 경우 예외를 발생시킨다.

### 커스텀 구분자 지정

- 문자열이 커스텀 구분자를 지정하는 패턴(//[구분자]\n[숫자])으로 시작하는 경우 해당 문자를 커스텀 구분자로 지정한다.
- 커스텀 구분자는 길이에 제한이 없고, `.`을 제외한 특수문자, 알파벳을 포함할 수 있다.

### 입력값 검증

- 입력 문자열이 null이거나 공백(whitespace)으로만 구성된 경우, 0을 반환한다.
- 분리된 값이 양수가 아닐 경우 IllegalArgumentException을 발생시킨다.
- 형식에 맞지 않는 문자가 포함된 경우 IllegalArgumentException을 발생시킨다.

### 총합 계산

- 구분자를 기준으로 분리된 숫자들의 합을 구한다.

### 입출력 처리

- 사용자에게 "덧셈할 문자열을 입력해 주세요."라는 문구를 출력하고 입력을 받는다.
- 계산 결과를 "결과 : {합계}" 형식으로 출력한다.
- 예외 발생 시 IllegalArgumentException을 발생시키고 애플리케이션을 종료한다.

## 테스트 사항

### 정상 케이스

- 양수(자연수와 비정수 실수)만 입력할 경우
- 양수와 구분자(기본 구분자, 커스텀 구분자)의 조합으로 구성된 경우
- 입력 문자열이 null이거나 공백(whitespace)인 경우

### 예외 케이스 (IllegalArgumentException 발생)

- 음수 혹은 0이 제공된 경우.
- 소수점 양식에 오류가 있는 경우.
- 숫자 혹은 구분자가 아닌 문자가 포함된 경우.
- 구분자가 연속으로 나와 숫자가 비어있는 부분이 있는 경우.
- 문자열이 구분자로 시작하거나 끝나는 경우.
- 허용되지 않은 문자를 커스텀 문자로 지정하는 경우.

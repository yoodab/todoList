# 나만의 일정 관리 앱 서버 만들기
프로그램 역할 : 나만의 일정을 관리하는 앱 서버
* 프로젝트 기간 : 2024.05.13 ~ 2024.05.17 (5일)
* 참여자 : 윤다빈
<br>

## 프로젝트 소개
<details>
<summary> 📑 요구사항 </summary>

* 공통 조건
  1. 일정 작성, 수정, 조회 시 반환 받은 일정 정보에 비밀번호는 제외 되어있습니다.
  2. 일정 수정, 삭제 시 선택한 일정의 비밀번호와 요청할 때 함께 보낸 비밀번호가 일치할 경우에만 가능합니다.
  
    1단계 : 일정 작성
     1. 할일 제목, 할일 내용, 담당자, 비밀번호, 작성일을 저장할 수 있습니다.
        a. 저장된 일정 정보를 반환 받아 확인할 수 있습니다.

  
    2단계 : 선택한 일정 조회
     1. 선택한 일정의 정보를 조회할 수 있습니다.
   
        
    3단계 : 일정 목록 조회
     1. 등록된 일정 전체를 조회할 수 있습니다.
     2. 조회된 일정 목록은 작성일 기준 내림차순으로 정렬 되어있습니다.
   
        
    4단계 : 선택한 일정 수정
     1. 선택한 일정의 할일 제목, 할일 내용, 담당자을 수정할 수 있습니다.
        a. 서버에 일정 수정을 요청할 때 비밀번호를 함께 전달합니다.
     2. 수정된 일정의 정보를 반환 받아 확인할 수 있습니다.
   
        
   5단계 : 선택한 일정 삭제
     1. 선택한 일정을 삭제할 수 있습니다.
        a. 서버에 일정 삭제를 요청할 때 비밀번호를 함께 전달합니다.

  




</details>
<details>
<summary>🏃‍♂️Use Case Diagram </summary>
  <img src="https://raw.githubusercontent.com/yoodab/todoList/1b15a49a21325d01420e4f749b9365ff540344cf/todoList.png" height="100%"/>
</details>

<details>
<summary> 📏ERD </summary>
  <img src="https://github.com/yoodab/todoList/blob/master/ERD.png?raw=true" height="80%"/>
</details>

<details>
<summary>🧾 API 명세서 </summary>
  [API 명세서](https://documenter.getpostman.com/view/23784910/2sA3JT1xdL)
  
<br>
  <img src="https://github.com/yoodab/todoList/assets/109517088/06662f39-2f34-4215-ae30-cacad5d17b35" height="80%"/>
</details>


<br>


## 🏗 프로젝트 구조
```
+---main
|   +---java
|   |   \---com
|   |       \---sparta
|   |           \---todolist
|   |               |   TodoListApplication.java
|   |               |
|   |               +---config
|   |               |       SwaggerConfig.java
|   |               |
|   |               +---controller
|   |               |       TodoController.java
|   |               |
|   |               +---dto
|   |               |       TodoRequestDto.java
|   |               |       TodoResponseDto.java
|   |               |
|   |               +---entity
|   |               |       Timestamped.java
|   |               |       Todo.java
|   |               |
|   |               +---exception
|   |               |       InvalidPasswordException.java
|   |               |       TodoExceptionHandler.java
|   |               |       TodoNotFoundException.java
|   |               |
|   |               +---repository
|   |               |       TodoRepository.java
|   |               |
|   |               \---service
|   |                       TodoService.java
|   |
|   \---resources
|       |   application.properties
|       |
|       +---static
|       \---templates
\---test
    \---java
        \---com
            \---sparta
                \---todolist
                        TodoListApplicationTests.java


```
<br>

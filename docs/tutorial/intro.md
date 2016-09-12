## Tutorial
tutorial에서 만들고자 하는 전체적인 구조는 다음과 같다.

```
- CommentBox		: 가장 바깥쪽에 있는 Layout을 의미
	- CommentList	: Comment가 List 형식으로 보여짐
		- Comment	: Comment는 '작성자 + 내용'으로 구성
	- CommentForm	: Comment를 입력할 수 있는 Form
```

구조 안에 있는 'CommentBox', 'CommentList', 'Comment', 'CommentForm' 전부 다 React의 컴포넌트 단위로 구성하여 작성할 것이다.

또한 이런 Comment를 입력 받고, 저장된 Comment를 JSON 형식으로 제공해주는 간단한 서버가 필요하다.  
해당 tutorial 에서는 그러한 서버를 Spring Boot를 이용했다.

만약 Spring Boot를 제외한 Node, Go, Ruby등 다른 서버 사이드 언어로 구현된 서버로 진행하고 싶으면  
[React 공식 홈페이지](https://facebook.github.io/react/index.html 'React 공식 홈페이지')에 들어가서 참조하면 될 것 같다. ([공식 Tutorial 번역 사이트](https://facebook.github.io/react/docs/getting-started-ko-KR.html '공식 Tutorial 번역 사이트'))

tutorial 진행은 step 별로 스크립트 파일과 md 파일이 존재한다.  

참고로 tutorial이 완성된 스크립트는 example.js 파일이다.
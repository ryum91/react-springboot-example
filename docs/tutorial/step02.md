# Step 02
[소스 코드 : [tutorial2.js](../../src/main/webapp/tutorial/js/tutorial2.js) , [tutorial3.js](../../src/main/webapp/tutorial/js/tutorial3.js)]

---

먼저 tutorial2.js를 통해 'CommentList'와, 'CommentForm' 컴포넌트를 만드는건  
Step01과 거의 동일하기 때문에 어렵지 않다.

하지만 ReactDOM.render로 실제 HTML에 그릴 수 있는 컴포넌트는 한 가지 뿐이다.

그렇다면 jsp에 DOM을 더 추가해서 ReactDOM.render 함수를 컴포넌트마다 호출하면 되지 않을까 싶지만  
그렇게 되면 우리가 하기로 했던 컴포넌트 구조에 맞지 않는다.  
컴포넌트 구조상 'CommentList'와, 'CommentForm'은 **'CommentBox'의 하위 컴포넌트**이기 때문이다.  

---

## Composite
여기서 React의 Composite 특징을 사용한다.  
여러개의 컴포넌트들을 하나의 컴포넌트처럼 조합 하는 것이다.

우리는 'CommentBox'컴포넌트에 'CommentList'와 'CommentForm'을 하위로 배치할 것이다.  
방법은 'CommentBox'컴포넌트를 선언할 때  
'CommentList'와 'CommentForm'을 일반 HTML 태그를 사용하듯이 사용하면 된다.

```jsx
var CommentBox = React.createClass({
	render: function() {
		return (
			<div className="commentBox">
				<h1>Comments</h1>
				<CommentList />			// CommentList 컴포넌트 호출
				<CommentForm />			// CommentForm 컴포넌트 호출
			</div>
		);
	}
});
```

여기서 React Component의 Naming Rule이 UpperCamelCase인 이유가 등장한다.  
소스 코드의 내부를 보면 소문자로 시작하는 태그들은 일반 HTML 태그와 동일하게 사용된다.  
하지만 대문자로 시작하는 태그들은 React Component라고 볼 수 있기 때문에 React Component는 대문자로 정의한다.

```
예제에서 'CommentBox'컴포넌트가 'CommentList'컴포넌트와 'CommentForm'컴포넌트를 사용하고 있다.
따라서 'CommentBox'컴포넌트가 'CommentList'컴포넌트와 'CommentForm'컴포넌트의 [부모 컴포넌트]라고도 한다.
```

tutorial3.js를 import 하여 실행해 보면 가장 상단에 &#60;h1&#62; 태그에 따른 Comments 라는 제목이 출력되고,  
각각 하위 컴포넌트에 따른 문자열이 출력되는 걸 볼 수 있다.
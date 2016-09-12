# Step 03
[소스 코드 : [tutorial4.js](../../src/main/webapp/tutorial/js/tutorial4.js) , [tutorial5.js](../../src/main/webapp/tutorial/js/tutorial5.js)]

---

## Property
React 컴포넌트에는 프로퍼티(Property) 라는 것이 존재한다.  
프로퍼티는 부모 컴포넌트에서 넘겨주는 값으로,  
컴포넌트 내부에서는 `this.props` 를 이용하여 접근한다.  
JSX에서의 이런 JavaScript 표현식은 중괄호를 이용하여 사용할 수 있다.

```JSX
// author 프로퍼티를 사용하는 코드
{this.props.author}
```

이런 프로퍼티는 일반 문자열, 객체, 함수 등 어떤 타입이든 지정할 수 있다.  
주의할 점으로는 프로퍼티는 외부에서 전달한 값이지, 컴포넌트가 자체적으로 관리하는 값이 아니다.  
그렇기 때문에 컴포넌트 내부에서 해당 프로퍼티를 변경하면 안된다는 점이다. (Immutable)

관련해서 이러한 프로퍼티와 관련된 속성들을 컴포넌트 만들때 사용하는 ReactElement 객체에 같이 정의할 수 있다.

#### - getDefaultProps [(API)](https://facebook.github.io/react/docs/component-specs-ko-KR.html#getdefaultprops)
프로퍼티의 기본값을 지정해주는 메서드로  
부모 컴포넌트에서 프로퍼티가 넘어오지 않은 경우, 해당 메서드의 반환된 리터럴 객체가 기본값으로 정의된다.  
주의할 점으로는 이 메서드는 컴포넌트가 만들어질 때 호출되는 것이 아니라, 컴포넌트가 정의될 때 호출된다.  
다시 말해서 컴포넌트가 정의될 때 한번 호출되고, 컴포넌트가 만들어질때는 캐시된 값을 불러와 수행한다. 

```JSX
// Comment 컴포넌트에 'author' 프로퍼티의 기본값을 지정한 예제
var Comment = React.createClass({
	getDefaultProps: function() {
		return {
			author: 'unknown'
		}
	},
	render: function() {
		return (
			<div className="comment">
				<h2 className="commentAuthor">
					{this.props.author}
				</h2>
				{this.props.children}
			</div>
		);
	}
});
```

#### - propTypes [(API)](https://facebook.github.io/react/docs/component-specs-ko-KR.html#proptypes)
이런 프로퍼티들은 얼마든지 정의하여 컴포넌트 내에서 사용할 수 있다.  
하지만 프로퍼티마다 각각의 특성이 있을 것이다.  
어떤 프로퍼티는 필수일 수 있으며, 어떤 프로퍼티는 선택일 수도 있다.  
또한 어떤 프로퍼티는 문자열이여야하며, 어떤 프로퍼티는 다른 컴포넌트여야만 할 수도 있다.

이럴때 사용하는 방식이 propTypes이다.  
간단하게 말하자면 부모 컴포넌트로 부터 받은 프로퍼티를 검증(Validation)하는 것이다.

```JSX
// React 공식 홈페이지 PropTypes 예제
React.createClass({
	propTypes: {
		// JavaScript 기본 데이터 타입에 대한 propTypes 종류
		optionalArray: React.PropTypes.array,
		optionalBool: React.PropTypes.bool,
		optionalFunc: React.PropTypes.func,
		optionalNumber: React.PropTypes.number,
		optionalObject: React.PropTypes.object,
		optionalString: React.PropTypes.string,

		// 렌더링될 수 있는 모든 것 (숫자, 문자열, 요소 등...)
		optionalNode: React.PropTypes.node,

		// React Element
		optionalElement: React.PropTypes.element,

		// 특정 클래스나 인스턴스
		optionalMessage: React.PropTypes.instanceOf(Message),

		// 특정 지정된 Enum
		optionalEnum: React.PropTypes.oneOf(['News', 'Photos']),

		// 여러개의 propTypes를 한 번에 사용
		optionalUnion: React.PropTypes.oneOfType([
			React.PropTypes.string,
			React.PropTypes.number,
			React.PropTypes.instanceOf(Message)
		]),

		// 특정 타입의 배열
		optionalArrayOf: React.PropTypes.arrayOf(React.PropTypes.number),

		// 특정 타입의 속성 값을 갖는 객체
		optionalObjectOf: React.PropTypes.objectOf(React.PropTypes.number),

		// 특정한 형태(shape)의 객체
		optionalObjectWithShape: React.PropTypes.shape({
			color: React.PropTypes.string,
			fontSize: React.PropTypes.number
		}),

		// 필수 프로퍼티에 대한 선언 (모든 프로퍼티에 공통적으로 사용 가능)
		requiredFunc: React.PropTypes.func.isRequired,

		// 모든 타입을 가능하게
		requiredAny: React.PropTypes.any.isRequired,

		// Custom Type을 지정해서 사용하는것도 가능하다.
		// 단, 검증에 실패하였을 땐 'Error' 객체를 리턴해야한다.
		// 만약 console.warn 이나, throw를 하게 되면 'oneOfType' 안에서 동작하지 않게 된다.
		customProp: function(props, propName, componentName) {
			if (!/matchme/.test(props[propName])) {
				return new Error('Validation failed!');
			}
		}
	},
	/* ... */
});
```

하지만 이런 프로퍼티의 검증을 하는 propTypes 메서드는 성능적인 이유로 실제 서비스 환경에서는 잘 쓰이지 않는다.  
또한 propTypes에 맞지 않는 프로퍼티를 전달하더라도  
에러가 발생하는 것이 아닌 `console.warn` 으로 출력 되기 때문에 개발 환경이 아닌, 실제 서비스 환경에서는 의미가 없다.  
[※ 참조: [React 공식 홈페이지 - PropTypes](https://facebook.github.io/react/docs/reusable-components-ko-KR.html) ]

#### - 프로퍼티 사용
React 컴포넌트에 필요한 프로퍼티들을 선언 하였다면  
부모 컴포넌트에서 해당 컴포넌트를 사용할 때 조건에 맞는 프로퍼티를 전달해야 할 것이다.

먼저 컴포넌트를 다른 컴포넌트에서 사용하는 방법에 대해서는 HTML 태그처럼 사용하는 것이라고 [Step02](./step02.md) 에서 언급했다.  
프로퍼티도 마찬가지이다. HTML 태그에서 프로퍼티를 전달하는 방식이랑 동일하다.

```JSX
// CommentList에서 프로퍼티가 지정된 'Comment' 컴포넌트를 사용하는 예제
var CommentList = React.createClass({
	render: function() {
		return (
			<div className="commentList">
				<Comment author="박지성">박지성 댓글 내용</Comment>
				<Comment author="손흥민">손흥민 댓글 내용</Comment>
			</div>
		);
	}
});
```

# Step 01
[소스 코드 : [tutorial1.js](../../src/main/webapp/tutorial/js/tutorial1.js) , [tutorial1-raw.js](../../src/main/webapp/tutorial/js/tutorial1-raw.js)]

---

## JSX
tutorial1.js 소스 코드를 봐보자.  
보면 소스 코드 내에 JavaScript 파일인데 불구하고 XML(HTML)과 유사한 부분이 보일 것이다.

```jsx
<div className="commentBox">
	I am CommentBox
</div>
```

이것을 [JSX](http://reactkr.github.io/react/docs/jsx-gotchas-ko-KR.html 'JSX') 문법 이라 한다. ([JSX 스펙](http://facebook.github.io/jsx/ 'JSX Specification'))

JSX는 JavaScript와 XML을 합친 단어로, JavaScript의 확장 문법이라 보면된다.  
React는 이러한 JSX를 이용해 JavaScript 내부에 HTML이나 XML같은 Markup Language를 사용할 수 있게 한다.  
또한 JSX는 JavaScript의 변수나 프로퍼티 값을 DOM에 직접 바인딩 할 수 있는 기능도 제공한다.

JSX에서 주의해야 할 점으로는 **JSX는 실제 HTML 태그가 아니라는 점**이다. 따라서 사용법도 비슷하면서 조금 차이가 있다.  
예를 들면 &#60;div&#62; 태그에 'commentBox' 라는 클래스를 지정하고 싶은 경우에는 다음과 같이 지정한다.
  
```jsx
/* HTML에서의 class 지정 방식 */
<div class="commentBox">...</div>

/* JSX에서의 class 지정 방식 */
<div className="commentBox">...</div>
```

이는 JavaScript의 예약어 문제를 피하기 위해서 이렇게 설계 되었다고한다.  
추가로 &#60;label&#62; 태그에 for 속성은 `<label htmlFor="...">` 이렇게 작성한다.

또 다른 점으로는 HTML 태그는 제대로 닫히지 않아도 에러가 발생하지 않지만,  
JSX는 같은 경우 **태그를 닫지 않는 경우 에러가 발생**하므로 문법 문제를 쉽게 알아차릴 수 있다는 점이다.  
관련해서는 [JSX - Tag and Attribute](https://facebook.github.io/react/docs/tags-and-attributes-ko-KR.html)에 좀 더 자세하게 설명 되어있다.

물론 React에서 이러한 JSX를 사용하지 않고, tutorial1-raw.js 처럼 순수 JavaScript로만 작성해서 사용해도 상관없다.  
하지만 JSX를 사용하는 이유는 HTML 문법과 비슷한 느낌으로 작성할 수 있어서 비엔지니어도 이해하기 쉽다는 장점이 있다.  
또한 React에 대한 지원이 순수 JavaScript로 작성하는 것 보다 더 좋은 편이기 때문에 굳이 사용을 안 할 이유가 없다.

---

## Syntax
Step 1 에서 사용된 간단한 문법을 살펴보자.
#### - Component Naming Rule
컴포넌트 이름은 'CommentBox'로  
React에서의 컴포넌트 이름은 **UpperCamelCase** 규칙을 따른다.

#### - React.createClass [(API)](https://facebook.github.io/react/docs/top-level-api-ko-KR.html#react.createclass 'React.createClass API')
컴포넌트를 선언할 때 사용하는 함수이다.  
해당 함수에 매개 변수로 [ReactElement](#reactElement) 라는 객체를 전달하여야한다.

#### <a id="reactElement"></a> - ReactElement [(API)](https://facebook.github.io/react/docs/component-specs-ko-KR.html 'ReactElement API')
ReactElement 객체를 생성할 때에는 render 메소드를 필수로 구현 해야한다.  
render 메소드는 무조건 하나의 컴포넌트를 반환해야하며, 최종적으로 실제 HTML DOM에 그려지게 되는 것이다.  
그러나 꼭 HTML 태그로 구성된 컴포넌트만 반환을 해야하는 건 아니다. 다른 곳에서 만들어진 컴포넌트를 반환해도 되며,  
여러개의 컴포넌트들을 조합해서 반환하는 것도 가능하다.  
단, 이런 컴포넌트들은 설계하고, 만들때에는 해당 컴포넌트가 어떤 타이밍에서 몇 번 호출 될 지 모르기 때문에 반드시 [멱등법칙](https://ko.wikipedia.org/wiki/%EB%A9%B1%EB%93%B1%EB%B2%95%EC%B9%99)을 따라야 한다.  
추가로 render 메소드 말고도 다른 메소드들도 optional하게 같이 선언 할 수 있다. (계속해서 설명 예정, 자세한건 API 참조)

#### - ReactDOM.render [(API)](https://facebook.github.io/react/docs/top-level-api-ko-KR.html#reactdom.render 'ReactDOM API')
첫번째 매개 변수로는 React 컴포넌트를,  
두번째 매개 변수로는 해당 React 컴포넌트가 바인딩 될 Container DOM을 전달한다.  
만약 이전에 해당 Container에 같은 컴포넌트가 바인딩 된 적 있다면,  
ReactDOM의 Diff 알고리즘을 사용하여 새롭게 수정된 부분의 DOM만 업데이트 된다.  
추가로 세번째 매개 변수에는 함수를 전달 할 수 있는데, 이는 바인딩이 끝난 뒤 호출되는 콜백 함수이다.

---

## Transpiler
이렇게 JSX와 React 문법이 포함된 JS파일을 HTML에서 불러오면 당연히 에러가 난다.  
그렇기 때문에 React를 사용하기 위해선 React 코드를 순수 JavaScript 형식으로 변환하여야 한다.  
그럴때 사용하는 것을 **Transpiler** 라고 한다.

이러한 Transpiler는 뿐만 아니라, [ECMAScript2015](http://www.ecma-international.org/ecma-262/6.0/ 'ECMAScript2015(ES6)'), [TypeScript](https://www.typescriptlang.org/ 'TypeScript'), [CoffeeScript](http://coffeescript.org/ 'CoffeScript') 등...  
아직 많은 브라우저가 지원을 안해주고, 실행이 불가능한 스크립트들을 실행 가능한 JavaScript 형식으로 변환하여준다.
  
최근에는 이런 Transpiler 중에 [Babel](https://babeljs.io/ 'Babel') 을 가장 많이 사용한다.  
Babel의 사용 방법을 간단하게 설명하자면 브라우저 컴파일/오프라인 컴파일 두 가지 방법이 있는데  
이번 Tutorial에서는 좀 더 편리한 브라우저 컴파일 방법으로 사용하는 것으로 진행한다.  
브라우저 컴파일을 사용하는 방법은 상단에 babel-core 스크립트 파일을 Import 하고,  
변환 할 JSX 스크립트 파일을 Import 할 때 type 속성을 '**text/babel**' 로 선언해주면  
클라이언트 브라우저에서 해당 스크립트 파일을 호환되는 스크립트로 변환한여 불러온다.
```html
<script src="https://cdnjs.cloudflare.com/ajax/libs/babel-core/5.8.23/browser.min.js"></script>
<script type="text/babel" scr="..."></script>
```
이렇게 아까 작성 한 tutorial1.js 파일을 babel을 이용해 index.jsp에 Import 하여  
CommentBox 컴포넌트가 제대로 바인딩이 되었다면  
'I am CommentBox' 라는 문자열이 화면에 출력되는 걸 볼 수 있다.

---

## Import File
#### - React
```html
<script src="https://cdnjs.cloudflare.com/ajax/libs/react/15.1.0/react.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/react/15.1.0/react-dom.js"></script>
```
기본적으로 React를 사용하기 위한 최소한의 Library 이다.  
npm으로 모듈 관리가 되면 import 할 필요가 없어지지만 해당 tutorial 에서는 필수로 import 해야 한다.

#### - Babel
```html
<script src="https://cdnjs.cloudflare.com/ajax/libs/babel-core/5.8.23/browser.min.js"></script>
```
Babel을 브라우저 컴파일 방법으로 사용하기 위한 Library 이다.  
만약 사전에 오프라인 컴파일로 변환하였다면 해당 파일은 import할 필요가 없다.  
(보통 배포된 컴포넌트들은 오프라인 컴파일로 미리 변환함)

#### - Util
```html
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/marked/0.3.5/marked.min.js"></script>
```
jQuery와 Markdown Library 이다.  
필수로 import 할 필요는 없지만, tutorial 진행을 위해 import 하였다.
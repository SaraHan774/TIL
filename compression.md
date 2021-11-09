### Compression 

이미 사용된 문자를 제거하는 GZIP Compression 알고리즘 

Google, Yahoo 에서도 사용됨 



Android 에서 하는 방법 

- 서버에 "내가 GZIP 을 프로세싱 할 것이니, GZIP 응답을 보내달라"고 얘기해야 함. 



okhttp 에서는 자동으로 요청에. Accept Encoding header를 추가 

받은 데이터를 자동으로 decompress 한다. 

`Accept-Encoding: gzip` 

-> `Encoding: gzip` 



Gzip 알고리즘 

- DEFLATE 알고리즘 기반 
  - LZ77, Huffman coding 의 조합 

Gzip 

- gzip 은 파일 압축에 쓰이는 응용 소프트웨어 
- gzip 은 GNU zip 의 준 말 
- 초기 유닉스 시스템에 쓰이던 압축 프로그램을 대체하기 위한 자유 소프트웨어. 
- 



Android 

java.util.zip.Deflater 



Content-Encoding 개체 헤더 

- 미디어 타입을 압축하기 위해서 사용됨. 
- 헤더가 존재하면, 그 값은 개체 본문에 어떤 추가적인 컨텐츠 인코딩이 적용될지 나타냄. 
- JPEG 이미지 같은 어떤 유형의 리소스들은 이미 압축되어, 때때로 추가적인 압축이 소용이 없을수도. 페이로드를 더 길게 만들 수 도 있다. 

문법 

- Content-Encoding: gzip 
- Content-Encoding: compress 

... 



<img src="/Users/gahee.han/Documents/스크린샷 2021-06-11 오후 2.04.48.png" alt="스크린샷 2021-06-11 오후 2.04.48"  />



Node.js 에서 gzip 으로 응답 보내기 

https://stackoverflow.com/questions/3894794/node-js-gzip-compression

```javascript
// server example
// Running a gzip operation on every request is quite expensive.
// It would be much more efficient to cache the compressed buffer.
var zlib = require('zlib');
var http = require('http');
var fs = require('fs');
http.createServer(function(request, response) {
  var raw = fs.createReadStream('index.html');
  var acceptEncoding = request.headers['accept-encoding'];
  if (!acceptEncoding) {
    acceptEncoding = '';
  }

  // Note: this is not a conformant accept-encoding parser.
  // See http://www.w3.org/Protocols/rfc2616/rfc2616-sec14.html#sec14.3
  if (acceptEncoding.match(/\bdeflate\b/)) {
    response.writeHead(200, { 'content-encoding': 'deflate' });
    raw.pipe(zlib.createDeflate()).pipe(response);
  } else if (acceptEncoding.match(/\bgzip\b/)) {
    response.writeHead(200, { 'content-encoding': 'gzip' });
    raw.pipe(zlib.createGzip()).pipe(response);
  } else {
    response.writeHead(200, {});
    raw.pipe(response);
  }
}).listen(1337);
```



LZUTF8



Socket 으로 주고받는 데이터에 대한 compress / decompress 에 대해서 



---

https://stackoverflow.com/questions/3664648/compressing-socket-send-data

> zlib 추천 / compress , decompress 패널티 관련 / 비동기 처리인지 동기인지 




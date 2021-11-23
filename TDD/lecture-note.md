- unit test
- integration test 
- end to end test
  -  위 순서대로 test cost 가 높아진다. 



- 모바일에서 테스팅 
  - espresso, kiwi, ... 
  - integration : OkHttp (mock server) 
  - e2e : apium, kalibash ? 
  - manual testing - 불가피함 

- Robolectric 

  - Instrumentation testing runner 
    - slow 
    - building, deploying and launching app 
    - dependent on emulator or device 
    - integration tests 
  - run directly from IDE 
  - handles inflation of views and resource loading 
  - gradle/maven support 

- Activity lifecycle 

  - inner test activities must be public for Robolectric.buildActivity to work 

  
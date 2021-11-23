1. release 할 때 버전코드 올리기 
2. 대소비교, AND, OR 조건 머지하기 전에 잘 확인하기 
3. 리뷰 받은 후에 테스트 다시 해보기 
4. **배포 예정 일 하루 전에 QA 마감 할 수 있도록 일정 맞추기** 

5. Activity extends BaseActivity/ Fragment extends BaseFragment 

---

	- use slack if not urgent 
	- always check branch, environment ! before answering code related questions 
	- remove duplicates 
	- check currency ! 
	- hotfix 브랜치는 반드시 master 브랜치에서 따는 것이어야 한다. 아직 배포되지 않은 릴리스 브랜치에 대해서는 develop 에서 따서 고쳐야 함 
	- 문제를 명확히 정의하기, 불필요하게 복잡한거면 다시 집고 넘어가기, 지쳤으면 잠시 한발짝 물러나서 생각해보자. 
	- ViewBinding 사용하기 (레이아웃 뷰 이름은 소문자와 _ 사용하기) 
	- Text 는 영문, 한글 폰트가 다르기때문에 style 에 지정된 text size 와 스타일링을 가져다가 사용해야한다. 
	- 라이선스 관련 문의는 내부 히스토리 파악한 후 문의하기 
	- QA 올릴 때 test fail 되면 문제 원인-해결 도 같이 적어서 다시 테스트 올리기. 티켓 작성 성실히 ... 

	-  QA 는 internal testing 에 올리고, 올리기 전에 version code / number 꼭 두 개 올리기 !!!!!!!!!!!!!!
	- 기능 한개만 추가할때는 꼭 develop 에 다른 티켓 들어간 상태인지 확인해야 함 

	- 기획안 / 디자인 받으면 구현 전에 반드시 꼼꼼하게 구현해야 할 사항들 목록 만들어두기 ...! 디자인 시안에 있는 것 빼먹지 말자 ... 


	- adapter should stay dumb about the data ! 



빌드 요청 -> 티켓 테스트로 바꾸기 
코드리뷰 제 때 잘 해두기 ...!! 


칼날 모양 선택하면 다운로드 가능한 애셋 목록 나와서, 일괄 다운로드 가능 


	- private / public 신경 쓰기 
	- interface 를 사용하는 이유 ? 생각하기 ? 
	- sealed class , enum ? 


Interface ? 확장 ? 
확장은 실제로 필요할 때 하면 된다. 
interface 도  한 곳에서 implementation 하는데 쓰이는 것이면 미리 만들어 놓을 필요가 없다. 
아무데서도 안쓰이는데, Base 나 interface 가 존재하면 의미도 없고 오히려 왜 존재하는지 궁금해한다. 
그리고 interface 에 서로 크게 연관 없어 보이는 많은 메소드들이 선언되어 있으면 interface 가 아니다. 
한 번 implementation 하는데 매번 interface 를 선언하도록 설명하는 이상한 책도 있지만, practical 하지 않다. 단발성 interface 들이 잘 설계되기도 힘들다. 

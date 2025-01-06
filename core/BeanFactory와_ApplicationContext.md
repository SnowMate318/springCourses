# BeanFactory와 ApplicationContext


### BeanFactory
* 어플리케이션의 최상위 인터페이스
* 스프링 빈 관리 및 조회 역할
* getBean() 제공



### ApplicationContext
* BeanFactory가 제공하는 모든 기능 상속
* 빈을 관리하고 검색하는기능은 BeanFactory도 가능한데 차이점이 뭘까
  * 어플리케이션을 개발할 때 빈을 관리하고 조회하는 기능은 물론이고, 수많은 부가 기능이 필요

#### ApplicationContext 구성

* MessageSource
  * 메세지소스를 활용한 국제화 기능
* EnvironmentCapable
  * 환경변수
* ApplicationEventPublisher
  * 어플리케이션 이벤트
* ResourceLoader
  * 편리한 리소스 조회




### 정리
* ApplicationContext는 BeanFactory 기능을 상속
* ApplicationContext는 빈 관리기능 + 편리한 부가기능
* BeanFactory를 사용할 일은 거의 없음 -> ApplicationContext 사용
* BeanFactory나 ApplicationContext를 빈 컨테이너라 함
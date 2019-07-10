

# 프로젝트 설계도 🗺


## src/main/java 설정 🚩

### Controller

- MainController	- index
- UserController	- 회원가입, 로그인, 마이페이지, 로그아웃, 장바구니 담기, 삭제
- AdminController	- 상품관리, 재고관리, 고객관리, 주문관리
- ProductController	- 상품검색, 상품목록조회, 상품상세조회
- OrderController	- 상품주문, 주문내역확인, 주문상세보기, 주문결제

<br>

### Service

- UserService
- AdminService
- ProductService
- OrderService

<br>

### Repository

- UserDao
- AdminDao
- ProductDao
- OrderDao

<br>

### Vo

- UserVo
- AddressVo
- CartVo

- CategoryVo
- ProductVo
- RepresentativeImageVo

- OptionVo
- OptionNameVo
- OrderOptionVo

- OrderVo
- OrderDetailVo


## src/test/java 설정 🚩

### config

- TestAppConfig
- TestWebConfig
- TestMVCConfig

### controller.api

- AdminControllerTest
- UserControllerTest
- ProductControllerTest
- OrderControllerTest

### service

- AdminServiceTest
- UserServiceTest
- ProductServiceTest
- OrderServiceTest

### repository

- 추후에 고려

### Scenario

- NotUserJoinScenarioTest
- UserCartOrderPayScenarioTest


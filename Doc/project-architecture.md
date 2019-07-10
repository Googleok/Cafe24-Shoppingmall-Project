

** 프로젝트 설계도


-- Controller

- MainController	- index
- UserController	- 회원가입, 로그인, 마이페이지, 로그아웃, 장바구니 담기, 삭제
- AdminController	- 상품관리, 재고관리, 고객관리, 주문관리
- ProductController	- 상품검색, 상품목록조회, 상품상세조회
- OrderController	- 상품주문, 주문내역확인, 주문상세보기, 주문결제

<hr>

-- Service

- UserService
- AdminService
- ProductService
- OrderService

-- Repository

- UserDao
- AdminDao
- ProductDao
- OrderDao

-- Vo

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



Test 설정
테스트용
config
controller
service
repository
만들기


























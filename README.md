# spring-server-starter
기본 TODO 예제를 통한 스타터


## 1. 프레임워크 선정
- **Spring Boot**

### 1.1. IDE 설정
- plugin
- sonaqube for ide


## 2. 개발 컨벤션

### 2.1 코드리뷰
- PR 템플릿, 이슈 템플릿 추가
- PR 단위: 기능 단위, 200줄 이하 권장
- Reviewer: 최소 1인 이상 승인 필요
- 리뷰 체크리스트 활용 (예: 로직 오류, 스타일, 네이밍)

### 2.2  템플릿

```jsx
커밋 메세지 포맷
AI 커밋 활용
```

```
feat: 새로운 기능 추가
fix: 버그 수정
refactor: 리팩토링
style: 코드 스타일 변경 (공백, 세미콜론 등)
chore: 빌드/테스트 설정 변경
```

### 2.3 린트 & 포맷터& IDE

- Java: Checkstyle, Spotless, Google java lint
- kotlin: Spotless

### 2.4 정적 분석 도구

- SonarCloud 활용

```
plugins {
  id "org.sonarqube" version "6.0.1.5171"
}

sonar {
  properties {
    property "sonar.projectKey", "dyno-jun_spring-server-starter"
    property "sonar.organization", "dyno-jun"
    property "sonar.host.url", "https://sonarcloud.io"
  }
}
```
### 2.5 CI/CD

- gitAction 활용
```
name: SonarQube
on:
  push:
    branches:
      - main
  pull_request:
    types: [opened, synchronize, reopened]
jobs:
  build:
    name: Build and analyze
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v4
        with:
          fetch-depth: 0  # Shallow clones should be disabled for a better relevancy of analysis
      - name: Set up JDK 17
        uses: actions/setup-java@v4
        with:
          java-version: 17
          distribution: 'zulu' # Alternative distribution options are available
      - name: Cache SonarQube packages
        uses: actions/cache@v4
        with:
          path: ~/.sonar/cache
          key: ${{ runner.os }}-sonar
          restore-keys: ${{ runner.os }}-sonar
      - name: Cache Gradle packages
        uses: actions/cache@v4
        with:
          path: ~/.gradle/caches
          key: ${{ runner.os }}-gradle-${{ hashFiles('**/*.gradle') }}
          restore-keys: ${{ runner.os }}-gradle
      - name: Build and analyze
        env:
          SONAR_TOKEN: ${{ secrets.SONAR_TOKEN }}
        run: ./gradlew build sonar --info
```
### 2.6 문서 작성

- **README**: 프로젝트 소개, 실행 방법, 주요 구조
- **CHANGELOG**: 버전별 변경사항 기록

### 2.7 아키텍처 정의
- 레이어 구조
    - Layered Architecture
    - Hexagonal Architecture

## 3. API 문서화

- RestDoc
    - 테스트 코드 별도로 작성해야 문서 생성됨.
- **Swagger (SpringDoc/OpenAPI)**
    - 자동 문서화, 개발 중 확인 용이
- **Postman**
    - 테스트 시나리오 저장, 협업 공유 용이

## 4. 인프라
- AWS 활용
    - 컨테이너 기반
    - ECS or Lambda
- IaC: Terraform

## 5. 테스트 전략

### 5.1 유틸 함수 테스트

- 단위 테스트로 커버리지 확보
- 로직이 복잡한 경우 TDD 방식 적용

### 5.2 비즈니스 로직 테스트

- Service 단위 테스트 (Mocking Repository)

### 5.3 도메인 레이어 테스트

- 엔티티 내부 상태 변화 테스트
- 도메인 이벤트 처리 로직 테스트

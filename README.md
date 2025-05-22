# spring-server-starter

Spring Boot 기반 백엔드 프로젝트 템플릿입니다.
코드 포맷팅, 정적 분석, Git Hook, 테스트 커버리지, 자동 릴리스/배포까지 포함된 CI/CD + 코드 품질 관리 기반의 스타터 프로젝트입니다.

---

## 🛠️ 시작하기

```bash
./gradlew clean build
```

> `clean` 시 자동으로 Git hook(`pre-commit`)이 `.git/hooks/`에 설치됩니다.

---

## 📁 템플릿 구성

### 이슈 템플릿

- Bug Report
- Feature Request

### PR 템플릿

- 제목: `feat:`, `fix:`, `chore:` 등 prefix 사용
- 본문: 관련 이슈 링크 포함

---

## 🧾 커밋 메시지 규칙 (Conventional Commits)

- `feat`: 새로운 기능
- `fix`: 버그 수정
- `chore`: 설정, 빌드, 의존성 등 비기능성 작업
- `docs`: 문서 수정
- `test`: 테스트 코드 추가/변경
- `refactor`: 리팩토링 (기능 변경 없음)

**예시:**

```bash
git commit -m "feat: 사용자 로그인 API 구현"
git commit -m "fix: 로그인 실패 시 예외 메시지 수정"
```

## ✅ 코드 린트 (Lint) - Spotless

```bash
./gradlew spotlessApply
./gradlew spotlessCheck
```

- `googleJavaFormat 1.27.0` 사용
- 불필요한 import 제거
- import 정렬 (알파벳 순)
- 줄 끝 공백 제거
- 마지막 줄 개행 추가

**적용 대상:**

- Java: `src/**/*.java`
- 기타: `.md`, `.gradle`, `.yml`, `.yaml`

---

## 🔍 정적 분석 도구 - SonarCloud

```groovy
sonar {
  properties {
    property "sonar.projectKey", "dyno-jun_spring-server-starter"
    property "sonar.organization", "dyno-jun"
    property "sonar.host.url", "https://sonarcloud.io"
  }
}
```

> GitHub Actions 또는 수동 실행으로 SonarCloud 연동 가능

---

## 📈 테스트 커버리지 - JaCoCo

```bash
./gradlew jacocoTestReport
```

- HTML 및 XML 리포트 생성
- 커버리지는 `build/reports/jacoco/`에서 확인 가능

---

## ⚙️ CI 구성

- PR 생성 및 `main` 브랜치 푸시 시 CI 실행
- 테스트, 린트, 정적 분석 자동 수행
- GitHub Actions 기반

---

## 🤖 AI 코드 리뷰

- PR 생성 시 자동 리뷰
- AI 기반으로 코드 스타일 및 설계 관점 피드백 예정

---

## 🚀 릴리즈 (Release) - semantic-release

- `main` 브랜치 푸시 시 semantic-release 실행
- 커밋 메시지 기반 SemVer 릴리즈 생성
- `CHANGELOG.md`, `build.gradle`의 버전, GitHub Release 자동 반영

---

## 🛳️ 배포 (CD) - GitHub Actions → ECS

- `dyno-v*.*.*` 형태의 태그 푸시 시 ECS로 자동 배포
- GitHub Actions → Amazon ECR → ECS Fargate
- 배포 완료 시 Slack 알림 전송

---

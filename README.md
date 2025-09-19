# 12th_Algorithm_Study

12기 시간초과단 팀에서 진행하는 알고리즘 백준 스터디입니다. <br/>
단순히 알고리즘 문제를 푸는 것에 그치지 않고,
알고리즘 개념을 정리하고 직접 문제를 풀어보며 사고 과정을 공유하는 것을 목표로 합니다. <br/>
매주 정해진 주제를 공부하고 백준 문제 2문제를 선정해 풀이와 설명을 정리합니다.

---

## 👥 스터디원

| 김민규 | 김세현 | 정유진 | 정예찬 |
|:------:|:------:|:------:|:------:|
| <img src="https://github.com/kingmingyu.png" width="150" height="150" /> | <img src="https://github.com/kkshyun.png" width="150" height="150" /> | <img src="https://github.com/marshmallowing.png" width="150" height="150" /> | <img src="https://github.com/metjyc.png" width="150" height="150" /> |
| [@kingmingyu](https://github.com/kingmingyu) | [@kkshyun](https://github.com/kkshyun) | [@marshmallowing](https://github.com/marshmallowing) | [@metjyc](https://github.com/metjyc) |
| 12기 BE | 11기 BE | 11기 BE | 12기 BE |

---

## 🗓️ 스터디 일정

- **정기 모임**: 매주 화요일 오후 9시
- **진행 방식**: 비대면 디스코드
- **과제 제출**: 매주 월요일 23:59까지

---

## 📖 학습 커리큘럼

| **주차** | **알고리즘 주제**                   | **출제자** |
| ------ | ----------------------------- | ------- |
| 1주차    | 스택, 큐, 우선순위 큐                 | 정예찬     |
| 2주차    | DFS & BFS                     | 김민규     |
| 3주차    | 백트래킹                          | 정유진     |
| 4주차    | 최단 경로 (다익스트라, 플로이드 워셜, 벨만 포드) | 정유진     |
| 5주차    | Greedy Algorithm              | 김민규     |
| 6주차    | Divide and Conquer            | 김민규     |
| 7주차    | 이분탐색                          | 정예찬     |
| 8주차    | 슬라이딩 윈도우                      | 정유진     |
| 9주차    | Dynamic Programming           | 김민규     |
| 10주차   | 해싱                            | 정유진     |
| 11주차   | 유니온 파인드                       | 김세현     |
| 12주차   | 최소 신장 트리                      | 김세현     |
| 13주차   | 위상 정렬                         | 김세현     |


---

## 🧭 스터디 진행 방식

- 매주 정해진 알고리즘 주제를 학습한다.(시험 기간 제외)
- 백준 문제 2문제를 선정하여 각자 풀이한다.
- 제출물은 아래 5가지로 구성된다.
    - (1) 알고리즘 정리 (이론 요약)
    - (2) 문제1 풀이 코드
    - (3) 문제1 풀이 방식 설명
    - (4) 문제2 풀이 코드
    - (5) 문제2 풀이 방식 설명
- 스터디 당일 랜덤 사다리타기로 발표자를 선정한다.
- 각 발표자는 알고리즘 정리, 문제 풀이(2문제)를 설명한다.
- 다음 주 출제자는 미리 문제를 선정해온다.

---

## 📁 디렉토리 구조

```bash
/
├── README.md                        
├── 📁 [kkshyun]/                    # 김세현 제출물
│   ├── 📁 week01/                   
│   │   ├── 📄 알고리즘정리(스택_큐_우선순위큐).md
│   │   ├── 📄 문제1_BOJ1234_풀이.py
│   │   ├── 📄 문제1_BOJ1234_풀이방식.md
│   │   ├── 📄 문제2_BOJ5678_풀이.py
│   │   └── 📄 문제2_BOJ5678_풀이방식.md
│   ├── 📁 week02/
│   │   ├── 📄 알고리즘정리(DFS_BFS).md
│   │   └── ...
│   └── ...
│
├── 📁 [kingmingyu]/                 # 김민규 제출물
│   ├── 📁 week01/
│   └── ...
│
├── 📁 [marshmallowing]/             # 정유진 제출물
│   ├── 📁 week01/
│   └── ...
│
├── 📁 [metjyc]/                     # 정예찬 제출물
│   ├── 📁 week01/
│   └── ...
│
└── 📁 assets/                       # 이미지/부가 자료
└── 📄 .gitignore                  # Git에서 제외할 파일 설정
```



## 🧑‍💻 GitHub 운영 방식

**1. 초기 설정**


  - 스터디 저장소를 로컬로 clone
  
    ```bash
    git clone https://github.com/IT-Cotato/12th_Algorithm_Study.git
    ```

  - 정리 내용 제출 전 본인 깃허브 핸들명으로 브랜치를 생성

    ```bash
    git checkout -b [본인 깃허브 핸들명]/week[n]
    ```


**2. 학습 내용 업로드**

  - 학습 내용을 md 형식으로 작성 후 커밋


**3. 커밋 및 PR 생성**

  - 커밋

    ```bash
    git add .
    git commit -m "[Docs] 김세현 n주차 제출"
    git push origin [본인 깃허브 핸들명]/week[n]
    ```

  - GitHub에서 develop 브랜치로 PR을 생성

  - PR 제목은 "[n주차] 이름" 형식으로 작성

**4. 다음 과제 세팅**

  - PR이 merge된 후, 최신 develop 브랜치를 pull

    ```bash
    git checkout develop
    git pull origin develop
    git checkout -b [본인 깃허브 핸들명]/week[n+1]
    ```

  - [본인 깃허브 핸들명] 폴더 내에 새로운 .md 파일을 생성하고 작성

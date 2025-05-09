INSERT INTO students (name, kana_name, nickname, email, area, age, sex)
VALUES ('山田太郎', 'ヤマダタロウ', 'タロー', 'taro.yamada@example.com', '東京',  25, '男性'),
       ('鈴木一郎', 'スズキイチロウ', 'イチロー', 'ichiro.suzuki@example.com', '大阪', 30, '男性'),
       ('佐藤花子', 'サトウハナコ', 'ハナ', 'hanako.sato@example.com', '福岡', 28, '女性'),
       ('高橋美咲', 'タカハシミサキ', 'ミサ', 'misaki.takahashi@example.com', '北海道', 18, '女性'),
       ('田中健', 'タナカケン', 'ケン', 'ken.tanaka@example.com', '沖縄', 22, 'その他');

INSERT INTO students_courses (student_id, course_name, course_start_at, course_end_at)
VALUES (5, 'Javaコース', '2025-01-01 00:00:00', '2025-03-31 00:00:00'),
       (1, '応用情報コース', '2025-02-01 00:00:00', '2025-04-30 00:00:00'),
       (3, '基礎学習コース', '2025-01-15 00:00:00', '2025-04-15 00:00:00'),
       (4, 'Web開発コース', '2025-03-01 00:00:00', '2025-06-30 00:00:00'),
       (2, 'エンジニアコース', '2025-02-15 00:00:00', '2025-05-15 00:00:00');

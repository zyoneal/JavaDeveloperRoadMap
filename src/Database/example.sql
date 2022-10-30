create table users (
    id bigserial constraint users_pk primary key,
    first_name text not null,
    last_name text not null,
    email text not null constraint users_email_uq unique
);

create table videos (
    id bigserial constraint videos_pk primary key,
    name text not null,
    location text not null,
    uploaded_at timestamp default now()
);

create table comments(
    id bigserial constraint comments_pk primary key,
    body text null,
    user_id bigint constraint comments_users_fk references users(id),
    video_id bigint constraint comments_videos_fk references videos(id),
    created_at timestamp default now()
);

create table user_friends(
    user_id bigint constraint users_friends_user_fk references users(id),
    friend_id bigint constraint users_friends_friend_fk references users(id),
    constraint user_friends_pk primary key (user_id, friend_id)
);

insert into users(first_name,last_name,email)
values('Viktor','Piven','viktor.piven@gmail.com'),
    ('Max','Karpenko','max@gmail.com'),;
    ('Andrii','Naumenko','andrii@gmail.com');

insert into videos(name,location)
values('SOLID princeples','http://solid.com'),('hibernate','hibernate.com'),('Docker','docker.com');

insert into comments(body,user_id,video_id) values
('This is bullsh*t',1,1),
('Hibernate top!',2,2),
('Nobody uses docker!!!',3,3);
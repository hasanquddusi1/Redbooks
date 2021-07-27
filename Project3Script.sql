drop TABLE IF exists customers cascade;
drop TABLE IF exists books cascade;
drop table IF EXISTS admins cascade;

create table customers(
	customer_id serial primary key, 
	customer_username varchar(20) not null,
	customer_password varchar(20) not NULL
);


create table admins(
	admin_id serial primary key,
	admin_username varchar(20) not null,
	admin_password varchar(20) not null
);


create table books(
	book_id serial primary key,
	book_name varchar(50) not null,
	book_author varchar(50) not NULL,
	genre varchar(25) NOT NULL,
	img_path varchar(100),
	file_path varchar(100)
);

insert into customers(customer_username, customer_password) values('jack', 'password');

INSERT INTO books(book_name, book_author, genre, img_path, file_path) values('The Thirty-Nine Steps', 'Jhon Buchan', 'adventure', 'https://therealredbook.s3.us-east-2.amazonaws.com/covers/the_thirty_nine_steps.jpg', 'https://therealredbook.s3.us-east-2.amazonaws.com/bookbody/the_thirty_nine_steps.txt');
INSERT INTO books(book_name, book_author, genre, img_path, file_path) values('Call of the wild', 'Jack London', 'adventure', 'https://therealredbook.s3.us-east-2.amazonaws.com/covers/call_of_the_wild.jpg', 'https://therealredbook.s3.us-east-2.amazonaws.com/bookbody/the_call_of_the_wild.txt');
INSERT INTO books(book_name, book_author, genre, img_path, file_path) values('Greenmantle', 'John Buchan', 'adventure', 'https://therealredbook.s3.us-east-2.amazonaws.com/covers/greenmantle.jpg', 'https://therealredbook.s3.us-east-2.amazonaws.com/bookbody/greenmantle.txt');
INSERT INTO books(book_name, book_author, genre, img_path, file_path) values('Kidnapped', 'Robert Louis Stevenson', 'adventure', 'https://therealredbook.s3.us-east-2.amazonaws.com/covers/kidnapped.jpg', 'https://therealredbook.s3.us-east-2.amazonaws.com/bookbody/kidnapped.txt');
INSERT INTO books(book_name, book_author, genre, img_path, file_path) values('King Solomons Mines', 'H. Rider Haggard', 'adventure', 'https://therealredbook.s3.us-east-2.amazonaws.com/covers/king_solomons_mines.jpg', 'https://therealredbook.s3.us-east-2.amazonaws.com/bookbody/king_solomons_mines.txt');
INSERT INTO books(book_name, book_author, genre, img_path, file_path) values('Tarzan of the Apes', 'Edgar Rice Burroughs', 'adventure', 'https://therealredbook.s3.us-east-2.amazonaws.com/covers/tarzan_of_the_apes.jpg', 'https://therealredbook.s3.us-east-2.amazonaws.com/bookbody/tarzan_of_the_apes.txt');
INSERT INTO books(book_name, book_author, genre, img_path, file_path) values('The Three Musketeers', 'Alexandre Dumas, Pre', 'adventure', 'https://therealredbook.s3.us-east-2.amazonaws.com/covers/the_three_musketeers.jpg', 'https://therealredbook.s3.us-east-2.amazonaws.com/bookbody/the_three_musketeers.txt');
INSERT INTO books(book_name, book_author, genre, img_path, file_path) values('Alices Adventures in Wonderland', 'Lewis Carroll', 'children', 'https://therealredbook.s3.us-east-2.amazonaws.com/covers/alice_in_wonderland.jpg', 'https://therealredbook.s3.us-east-2.amazonaws.com/bookbody/alice_in_wonderland.txt');
INSERT INTO books(book_name, book_author, genre, img_path, file_path) values('Peter Pan and Wendy', 'James M. Barrie', 'children', 'https://therealredbook.s3.us-east-2.amazonaws.com/covers/peter_pan.jpg', 'https://therealredbook.s3.us-east-2.amazonaws.com/bookbody/peter_pan.txt');
INSERT INTO books(book_name, book_author, genre, img_path, file_path) values('The Jungle Book', 'Rudyard Kipling', 'children', 'https://therealredbook.s3.us-east-2.amazonaws.com/covers/the_junglebook.jpg', 'https://therealredbook.s3.us-east-2.amazonaws.com/bookbody/the_jungle_book.txt');
INSERT INTO books(book_name, book_author, genre, img_path, file_path) values('The Legend of Sleepy Hollow', 'Washington Irving', 'children', 'https://therealredbook.s3.us-east-2.amazonaws.com/covers/the_legend_of_sleepy_hollow.jpg', 'https://therealredbook.s3.us-east-2.amazonaws.com/bookbody/the_legend_of_sleepy_hollow.txt');
INSERT INTO books(book_name, book_author, genre, img_path, file_path) values('The Secret Garden', 'Frances Hodgson Burnett', 'children', 'https://therealredbook.s3.us-east-2.amazonaws.com/covers/the_secret_garden.jpg', 'https://therealredbook.s3.us-east-2.amazonaws.com/bookbody/the_secret_garden.txt');
INSERT INTO books(book_name, book_author, genre, img_path, file_path) values('The Wind in the Willows', 'Kenneth Grahame', 'children', 'https://therealredbook.s3.us-east-2.amazonaws.com/covers/the_wind_and_the_willows.jpg', 'https://therealredbook.s3.us-east-2.amazonaws.com/bookbody/the_wind_and_the_willows.txt');
INSERT INTO books(book_name, book_author, genre, img_path, file_path) values('Through the Looking-Glass', 'Charles Dodgson, AKA Lewis Carroll', 'children', 'https://therealredbook.s3.us-east-2.amazonaws.com/covers/through_the_looking_glass.jpg', 'https://therealredbook.s3.us-east-2.amazonaws.com/bookbody/through_the_looking_glass.txt');
INSERT INTO books(book_name, book_author, genre, img_path, file_path) values('Treasure Island', 'Louis Rhead', 'children', 'https://therealredbook.s3.us-east-2.amazonaws.com/covers/treasure_island.jpg', 'https://therealredbook.s3.us-east-2.amazonaws.com/bookbody/treasure_island.txt');
INSERT INTO books(book_name, book_author, genre, img_path, file_path) values('The Odyssey', 'Homer', 'classic', 'https://therealredbook.s3.us-east-2.amazonaws.com/covers/the_odyssey.jpg', 'https://therealredbook.s3.us-east-2.amazonaws.com/bookbody/the_odyssey.txt');
INSERT INTO books(book_name, book_author, genre, img_path, file_path) values('Pride and Prejudice', 'Jane Austen', 'classic', 'https://therealredbook.s3.us-east-2.amazonaws.com/covers/pride_and_prejudice.jpg', 'https://therealredbook.s3.us-east-2.amazonaws.com/bookbody/pride_and_prejudice.txt');
INSERT INTO books(book_name, book_author, genre, img_path, file_path) values('The Adventures of Sherlock Holmes', 'Arthur Conan Doyle', 'mystery', 'https://therealredbook.s3.us-east-2.amazonaws.com/covers/the_adventures_of_sherlock_holmes.jpg', 'https://therealredbook.s3.us-east-2.amazonaws.com/bookbody/the_adventures_of_sherlock_holmes.txt');
INSERT INTO books(book_name, book_author, genre, img_path, file_path) values('The Last Stroke', 'Lawrence L. Lynch', 'mystery', 'https://therealredbook.s3.us-east-2.amazonaws.com/covers/the_last_stroke.jpg', 'https://therealredbook.s3.us-east-2.amazonaws.com/bookbody/the_last_stroke.txt');
INSERT INTO books(book_name, book_author, genre, img_path, file_path) values('The Mysterious Affair at Styles', 'Agatha Christie', 'mystery', 'https://therealredbook.s3.us-east-2.amazonaws.com/covers/the_mysterious_affair_at_styles.jpg', 'https://therealredbook.s3.us-east-2.amazonaws.com/bookbody/the_mysterious_affair_at_styles.txt');
INSERT INTO books(book_name, book_author, genre, img_path, file_path) values('The Return of Sherlock Holmes', 'Arthur Conan Doyle', 'mystery', 'https://therealredbook.s3.us-east-2.amazonaws.com/covers/the_return_of_sherlock_holmes.jpg', 'https://therealredbook.s3.us-east-2.amazonaws.com/bookbody/the_return_of_sherlock_holmes.txt');
INSERT INTO books(book_name, book_author, genre, img_path, file_path) values('The Secret Adversary', 'Agatha Christie', 'mystery', 'https://therealredbook.s3.us-east-2.amazonaws.com/covers/the_secret_adversary.jpg', 'https://therealredbook.s3.us-east-2.amazonaws.com/bookbody/the_secret_adversary.txt');
INSERT INTO books(book_name, book_author, genre, img_path, file_path) values('The First Men In The Moon', 'H. G. Wells', 'fiction', 'https://therealredbook.s3.us-east-2.amazonaws.com/covers/the_first_men_in_the_moon.jpg', 'https://therealredbook.s3.us-east-2.amazonaws.com/bookbody/the_first_men_in_the_moon.txt');
INSERT INTO books(book_name, book_author, genre, img_path, file_path) values('The Time Machine', 'H. G. Wells', 'fiction', 'https://therealredbook.s3.us-east-2.amazonaws.com/covers/the_time_machine.jpg', 'https://therealredbook.s3.us-east-2.amazonaws.com/bookbody/the_time_machine.txt');
INSERT INTO books(book_name, book_author, genre, img_path, file_path) values('The War of the Worlds', 'H. G. Wells', 'fiction', 'https://therealredbook.s3.us-east-2.amazonaws.com/covers/the_war_of_the_worlds.jpg', 'https://therealredbook.s3.us-east-2.amazonaws.com/bookbody/the_war_of_the_worlds.txt');
INSERT INTO books(book_name, book_author, genre, img_path, file_path) values('A Sagebrush Cinderella', 'Max Brand', 'western', 'https://therealredbook.s3.us-east-2.amazonaws.com/covers/a_sagebrush_cinderella.jpg', 'https://therealredbook.s3.us-east-2.amazonaws.com/bookbody/a_sagebrush_cinderella.txt');
INSERT INTO books(book_name, book_author, genre, img_path, file_path) values('The Devil Dooryard', 'Wilbur Coleman Tuttle', 'western', 'https://therealredbook.s3.us-east-2.amazonaws.com/covers/the_devils_dooryard.jpg', 'https://therealredbook.s3.us-east-2.amazonaws.com/bookbody/the_devils_dooryard.txt');
INSERT INTO books(book_name, book_author, genre, img_path, file_path) values('The Mark of Zorro', 'Johnston McCulley', 'western', 'https://therealredbook.s3.us-east-2.amazonaws.com/covers/the_mark_of_zorro.jpg', 'https://therealredbook.s3.us-east-2.amazonaws.com/bookbody/the_mark_of_zorro.txt');
INSERT INTO books(book_name, book_author, genre, img_path, file_path) values('The Mysterious Rider', 'Zane Grey', 'western', 'https://therealredbook.s3.us-east-2.amazonaws.com/covers/the_mysterious_rider.jpg', 'https://therealredbook.s3.us-east-2.amazonaws.com/bookbody/the_mysterious_rider.txt');
INSERT INTO books(book_name, book_author, genre, img_path, file_path) values('The Riders of Ramapo Pass', 'Dean L. Heffernan', 'western', 'https://therealredbook.s3.us-east-2.amazonaws.com/covers/the_riders_of_ramapo_pass.jpg', 'https://therealredbook.s3.us-east-2.amazonaws.com/bookbody/the_riders_of_ramapo_pass.txt');
INSERT INTO books(book_name, book_author, genre, img_path, file_path) values('The Time Snatcher', 'Randall Garrett', 'western', 'https://therealredbook.s3.us-east-2.amazonaws.com/covers/the_time_snatcher.jpg', 'https://therealredbook.s3.us-east-2.amazonaws.com/bookbody/the_time_snatcher.txt');



# SciFi UI Project

Name: Glenn Moore

Student Number: C17390923


# Description of the assignment
For this assignment, I decided to do a UI for a Sci-Fi spaceship. The ship I took inspiration from was the 
Benatar in Guardians of the Galaxy. I am a huge fan of this film and decided to try my hand at making a functioning ship appear. 
I included controls for making the ship move faster, and also experimented with playing sound in the sketch, specifically,
the Awesome Mix Vol.1 from the original movie.

# Instructions
Below are the buttons and keys that can be pressed and the corresponding functionality behind each one.
This is a table:

| Button/Key | Function |
|-----------|-----------|
|S key | When pressed, ship should double in speed (ie go to lightspeed), speedometer will change |
|W key | When pressed, will return the speed of the ship back to it's default (50mph) |
|Jukebox button on screen | When clicked, will change tracks on the Awesome Mix soundtrack. |
|Soundwave | When you speak or make noise, the waves will move. |


# How it works

# What I am most proud of in the assignment
The thing that I am most proud of in my assignment is the fact that I was able to successfully import sound in a way that the 
user can interact with it. Adding the soundtrack and giving the user the ability to change the song both allowed me to learn
more about how the Minim library works and also lets the user interact with my assignment in a meaningful way.

Another thing I am proud of is how I managed to successfully animate both stars and planes procedurally. I experiemented
with using abstract classes, PVectors, and ArrayLists among others to allow this to happen. I kept both stars and planets in
the same arrayList (called sprites) and was able to animate each of them in a different way by overriding the methods in the 
abstract class. Given how I struggled with basic drawing and animation in Processing for a very long time, I am happy to say
that I am now able to procedurally animate my own background for a sketch.

# Markdown Tutorial

This is *emphasis*

This is a bulleted list

- Item
- Item

This is a numbered list

1. Item
1. Item

This is a [hyperlink](http://bryanduggan.org)

# Headings
## Headings
#### Headings
##### Headings

This is code:

```Java
public void render()
{
	ui.noFill();
	ui.stroke(255);
	ui.rect(x, y, width, height);
	ui.textAlign(PApplet.CENTER, PApplet.CENTER);
	ui.text(text, x + width * 0.5f, y + height * 0.5f);
}
```

So is this without specifying the language:

```
public void render()
{
	ui.noFill();
	ui.stroke(255);
	ui.rect(x, y, width, height);
	ui.textAlign(PApplet.CENTER, PApplet.CENTER);
	ui.text(text, x + width * 0.5f, y + height * 0.5f);
}
```

This is an image using a relative URL:

![An image](images/p8.png)

This is an image using an absolute URL:

![A different image](https://bryanduggandotorg.files.wordpress.com/2019/02/infinite-forms-00045.png?w=595&h=&zoom=2)

This is a youtube video:

[![YouTube](http://img.youtube.com/vi/J2kHSSFA4NU/0.jpg)](https://www.youtube.com/watch?v=J2kHSSFA4NU)

This is a table:

| Heading 1 | Heading 2 |
|-----------|-----------|
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |


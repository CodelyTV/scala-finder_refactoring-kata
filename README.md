# Incomprehensible Finder Refactoring Scala
 
## Introduction 

Here is the bad news: the new developer you hired has written some terrible, atrocious code. 
No one can understand what it does. 

The good news: at least there are unit tests to prove the code is working. 

You job is to refactor the code and make it readable, while keeping the code in working order (pass all tests). 

Important: The new developer had a very strong Java background, so the code you'll find is not very idiomatic scala.
Try to put in practice all your scala knowledge making use of the most idiomatic techniques and getting rid off the Java essence :) 

## How To Start

1. Clone this repository `git clone https://github.com/CodelyTV/incomprehensible-finder-refactoring-kata-scala`
2. Install [SBT](http://www.scala-sbt.org/)
3. Run SBT on the project directory `sbt`
4. Run the tests with `t`. You also have available the `s` and `ts` commands which runs the [scalastyle](http://www.scalastyle.org/) over the production and test code.
5. Start refactoring! 

The primary goal is to refactor the code in `src/main/scala/tv/codely/finderKata/algorithm/Finder.scala` - as it stands the code is incomprehensible. 

## Tips

* Start with simple rename refactors so you can better understand the abstractions you are working with. Rename any class or any variable. 
* Move on to extract methods and making the code more modular.
* See if you can also eliminate pattern matchings and multiple exit points from methods. 

Anything is fair game, create new classes, new methods, and rename tests. 
The only restriction is that the existing tests have to keep working. 
Lean on the tests and run them after every small change to make sure you are on the right path.

## How to End

You can stop when you feel the code is good enough, something you can come back to in 6 months and understand. 

## Helpful resources

### Refactoring

* [Refactoring.guru Code Smells catalog](https://refactoring.guru/smells/smells)
* [Refactoring.guru Refactorings catalog](https://refactoring.guru/catalog)
* [SourceMaking Refactorings catalog](https://sourcemaking.com/refactoring)
* [Martin Fowler Refactorings catalog](http://refactoring.com/catalog/)
* [CodelyTV Refactoring videos (Spanish)](http://codely.tv/tag/refactoring/)

## Credits and other programming languages

This kata is a Scala port of [the original Incomprehensible Finder Refactoring Kata](https://github.com/OdeToCode/Katas/tree/master/Refactoring) created by [K. Scott Allen](https://github.com/OdeToCode).

You can also find the kata in different programming languages in isolated repositories just ready to clone and enjoy: 
* [Java](https://github.com/DoDevJutsu/incomprehensible-finder-refactoring-java)
* [C#](https://github.com/DoDevJutsu/incomprehensible-finder-refactoring-c-sharp)
* [PHP](https://github.com/CodelyTV/incomprehensible-finder-refactoring-kata)
* [Scala](https://github.com/CodelyTV/incomprehensible-finder-refactoring-kata-scala)

This port has been developed by [CodelyTV](http://codely.tv/) in order to have it available for the [Software Craftsmanship Barcelona Coding Dojo session](http://www.meetup.com/Barcelona-Software-Craftsmanship/events/233107734/).
Come with us and have some fun if you're near Barcelona the next Monday, August 22nd!

# CMPUT 301 - Lab 6: Code Documentation and Unit Testing

## 1. Walkthrough
1. <ins>Create a new project named `lab-6` on Android Studio (File > New > New Project > Select "Empty Activity").</ins>
> [!WARNING]
> Make sure that the project language is **Kotlin**, not Java!

### Code documentation with KDoc and Dokka
2. <ins>Set up Dokka</ins>
  - In the `build.gradle.kts (:app)` file, add `id("org.jetbrains.dokka") version "2.2.0"` in the `plugins` section:
    ```kotlin
    plugins {
        alias(libs.plugins.android.application)
        alias(libs.plugins.kotlin.compose)
        id("org.jetbrains.dokka") version "2.2.0"
    }
    ```
  - Make sure you **sync** your project after applying the change

> [!NOTE]
> The most stable and latest version of Dokka may change from 2.2.0

3. <ins>Create a class and method to write KDoc comments for</ins>
  - Create a new `Wizard` Class:
  ```kotlin
  class Wizard(val name: String, var mana: Int, var spellPower: Int) { }
  ```

  - Create a function called `castSpell()` in the `Wizard` class:
  ```kotlin
  fun castSpell(spell: String): Int { }
  ```

  - Define the rest of `castSpell()` as such:
  ```kotlin
  fun castSpell(spell: String): Int {
        when (spell) {
            "Explosion" -> {
                if (mana >= 10) {
                    mana -= 10
                    return spellPower * 3
                } else return 0 // not enough mana
            }
            "Frostbite" -> {
                if (mana >= 5) {
                    mana -= 5
                    return spellPower * 2
                } else return 0 // not enough mana
            }
            else -> {
                return 0 // invalid spell
            }
        }
    }
  ```

  - Let's write KDoc comments for `Wizard`:
  ```kotlin
  /**
   * Represents a wizard character that can cast spells using mana.
   *
   * A wizard has a name, current mana, and spell power stat. The
   * wizard needs sufficient mana to cast spells, and spell power
   * is used to calculate how much damage is dealt when a valid
   * spell is cast.
   *
   * @property name the name of the wizard
   * @property mana the current mana available for casting spells
   * @property spellPower the base power used for spell damage calculation
   */
  ```

  - Let's also write KDoc comments for `castSpell()`:
  ```kotlin
  /**
   * Casts a spell and returns the damage dealt
   *
   * Supported spells:
   * - "Explosion": costs 10 mana, deals 3 × spellPower damage
   * - "Frostbite": costs 5 mana, deals 2 × spellPower damage
   *
   * If the wizard does not have enough mana or the spell name is invalid,
   * the spell fails and returns 0.
   *
   * @param spell the name of the spell to cast
   * @return the integer amount of damage dealt, or 0 if the spell fails
   */
  ```

4. <ins>Generate HTML documentation using Dokka</ins>
  - In the terminal, from the root of the project, run the command `./gradlew dokkaGenerateHtml`
  - In your file explorer, find your `lab-6` project and navigate to `../lab6/app/build/dokka/html`
    - Find and open the `index.html` file.
    - Check out the documentation you created!
   
### Unit Testing with JUnit
5. <ins>Create tests</ins>
 - First, delete the `ExampleUnitTest` File
 - Then, create a new file called `WizardTest` under the folder `com.example.lab_6 (test)`
 - Add the following setup code in `WizardTest` inside the WizardTest class@Test
fun castSpell_explosion_successful() {
    val damageDealt = evilWizard.castSpell("Explosion")

    assertEquals(30, damageDealt) // spellPower of 10 * 3 = 30

    assertEquals(20, evilWizard.mana) // mana of 30 - 10 = 20
}:
 ```kotlin
 private lateinit var evilWizard: Wizard

 // Set up a new wizard before every single test
 @Before
 fun setUp() {
     evilWizard = Wizard("Evil Wizard", 30, 10)
 }
 ```
> Make sure to import the class `Before` 

- Make a test to check the behaviour when we successfully cast an explosion spell:
```kotlin
@Test
fun castSpell_explosion_successful() {
    val damageDealt = evilWizard.castSpell("Explosion")

    assertEquals(30, damageDealt) // spellPower of 10 * 3 = 30

    assertEquals(20, evilWizard.mana) // mana of 30 - 10 = 20
}
```
> Make sure to import the class `Test` and the function `assertEquals`

- Next, make another test to check the behaviour when we do not have enough mana to cast an explosion spell:
```kotlin
@Test
fun castSpell_explosion_unsuccessful() {
    evilWizard.mana = 5 // Evil Wizard does not have enough mana to cast "Explosion"
    val damageDealt = evilWizard.castSpell("Explosion")

    assertEquals(0, damageDealt)

    assertEquals(5, evilWizard.mana) // mana still is 5
}
```

6. <ins>Run the tests</ins>
- One way to do this is to right-click the `WizardTest` file and click `Run 'WizardTest'`
- You should see that 2/2 tests passed!

> [!NOTE]
> - The `walkthrough.md` contains the complete code for `Wizard`, `WizardTest`, and `build.gradle.kts (:app)` for double-checking purposes
> - While you could simply copy and paste the code, you're stripping yourself of a learning opportunity :)

## 2. Lab 6 Participation Exercise
If you've been following along with the walkthrough, this exercise should be fairly straightforward!
1. Make a test to check the behaviour when we successfully cast a *frostbite* spell
2. Make another test to check the behaviour when we do not have enough mana to cast a *frostbite* spell

## 3. Submission Specifications
1. Fork and then clone this repository
    - Make sure your forked repository is **public**
    - Hint: Use `git clone`
3. Add your Android Studio Project to your forked repository
    - Hint: Use `git add`, `git commit`, and `git push`
    - Make sure to upload all your generated Dokka files, since the Dokka output folder is inside `/build`, which is often included in `.gitignore` by default.
4. Update the `README.md` file with your details and references/collaborators
5. Update the `LICENSE.md` file with your full name
6. Submit the link to your GitHub repository on Canvas

> [!IMPORTANT]
> - This lab is graded on a complete/incomplete basis. You will receive a “complete” if you finish the walkthrough, complete the participation exercise, and follow ALL submission requirements. You will receive an “incomplete” if any of these requirements are not met, such as an inaccessible (non-public) repository, missing participation exercise, or an incorrect submission.
> - **There will be no exceptions, partial marks, or late submissions allowed.**

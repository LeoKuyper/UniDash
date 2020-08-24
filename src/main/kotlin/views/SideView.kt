package views

import javafx.geometry.Pos
import javafx.scene.paint.Color
import javafx.scene.text.TextAlignment
import tornadofx.*

class SideView:View() {
    override val root = vbox() {
        setPrefSize(200.0, 960.0)
        useMaxHeight = true

        label ("UniDash"){
            setPrefSize(200.0, 10.0)
            vboxConstraints {
                marginTop = 10.0
                marginBottom = 10.0
                alignment = Pos.CENTER
            }
            style{
                textFill = Color.rgb(255, 255, 255)
                textAlignment = TextAlignment.CENTER
            }
        }

        button("University") {

            action { println("University Button pressed!")


            vboxConstraints {
                marginTop = 30.0
                marginLeft = 30.0
                marginRight = 30.0
                marginBottom = 30.0
                alignment = Pos.CENTER
            }
        }
        button("Subjects") {

            action { println("Subjects Button pressed!") }

            vboxConstraints {
                marginTop = 30.0
                marginLeft = 30.0
                marginRight = 30.0
                marginBottom = 30.0
                alignment = Pos.CENTER
            }
        }
        button("People") {

            action { println("People Button pressed!") }

            vboxConstraints {
                marginTop = 30.0
                marginLeft = 30.0
                marginRight = 30.0
                marginBottom = 30.0
                alignment = Pos.CENTER
            }
        }
        button("Pool") {

            action { println("Pool Button pressed!") }

            vboxConstraints {
                marginTop = 30.0
                marginLeft = 30.0
                marginRight = 30.0
                marginBottom = 30.0
                alignment = Pos.CENTER
            }
        }

        style{
            backgroundColor += Color.rgb(22, 41, 53)
        }

    }
    }

}
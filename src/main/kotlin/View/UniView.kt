package View

import javafx.beans.property.SimpleStringProperty
import javafx.geometry.Pos
import javafx.scene.paint.Color
import javafx.scene.text.TextAlignment
import tornadofx.*
import university.UniDash
import university.UniDashViewModel

class UniView: View() {
    val uniDashViewModel = UniDashViewModel(UniDash())


    var people = SimpleStringProperty(uniDashViewModel.getAllPeople().toString()).value.toString()


    override val root = vbox {
        val subject = uniDashViewModel.subject.value
        borderpane {



            left = vbox() {
                setPrefSize(200.0, 960.0)
                useMaxHeight = true

                label ("UniDash"){
                    setPrefSize(200.0, 30.0)
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

                label (uniDashViewModel.getUniName()){
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

                label ("Subjects: " + uniDashViewModel.getSubjectsCount().toString()){
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
                label ("Diploma Students: " + uniDashViewModel.getDiStudentCount().toString()){
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

                label ("Degree Students: " + uniDashViewModel.getDeStudentCount().toString()){
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

                label ("Academic Staff: " + uniDashViewModel.getAcStaffCount().toString()){
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

                label ("Administrative Staff: " + uniDashViewModel.getAdStaffCount().toString()){
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

                label ("All people: " + people){
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



                style{
                    backgroundColor += Color.rgb(22, 41, 53)
                }

            }

            top = vbox{
                setPrefSize(100.0, 30.0)

                useMaxWidth = true

                style{
                    backgroundColor += Color.rgb(22, 41, 53)
                }
            }


            center = vbox{
                setPrefSize(1000.0, 960.0)
                useMaxWidth = true
                style{
                    backgroundColor += Color.rgb(20, 31, 38)
                }

                borderpane {

                    left = vbox {
                        label ("Users"){
                            style{
                                backgroundColor += Color.WHITE
                            }
                        }

                        button("GetName") {
                            action {
                                println("Get name")
                                uniDashViewModel.getName()
                                uniDashViewModel.addPerson("Leo", 0)
                                println(uniDashViewModel.getDiStudentCount())
                                onRefresh()

                            }
                        }

                        setPrefSize(450.0, 320.0)

                        vboxConstraints {
                            marginTop = 30.0
                            marginLeft = 30.0
                            marginRight = 30.0
                            marginBottom = 30.0
                        }
                        style{
                            backgroundColor += Color.rgb(30, 31, 38)
                        }
                    }
                   right = vbox {
                        label ("Subjects"){
                            style{
                                backgroundColor += Color.WHITE
                            }
                        }

                        setPrefSize(450.0, 302.0)

                       vboxConstraints {
                           marginTop = 30.0
                           marginLeft = 30.0
                           marginRight = 30.0
                           marginBottom = 30.0
                       }
                        style{
                            backgroundColor += Color.rgb(30, 31, 38)
                        }
                    }

                    vboxConstraints {
                        marginTop = 30.0
                        marginLeft = 30.0
                        marginRight = 30.0
                        marginBottom = 30.0
                        alignment = Pos.CENTER
                    }
                    style{
                        backgroundColor += Color.rgb(142, 172, 191)
                    }

                }

                borderpane {

                    left = vbox {
                        label ("Register people"){
                            style{
                                backgroundColor += Color.WHITE
                            }
                        }

                        setPrefSize(450.0, 320.0)

                        vboxConstraints {
                            marginTop = 30.0
                            marginLeft = 30.0
                            marginRight = 30.0
                            marginBottom = 30.0
                        }
                        style{
                            backgroundColor += Color.rgb(30, 31, 38)
                        }
                    }
                    right = vbox {
                        label ("new subjects"){
                            style{
                                backgroundColor += Color.WHITE
                            }
                        }

                        setPrefSize(450.0, 302.0)

                        vboxConstraints {
                            marginTop = 30.0
                            marginLeft = 30.0
                            marginRight = 30.0
                            marginBottom = 30.0
                        }
                        style{
                            backgroundColor += Color.rgb(30, 31, 38)
                        }
                    }

                    vboxConstraints {
                        marginTop = 30.0
                        marginLeft = 30.0
                        marginRight = 30.0
                        marginBottom = 30.0
                        alignment = Pos.CENTER
                    }
                    style{
                        backgroundColor += Color.rgb(142, 172, 191)
                    }

                }

                borderpane {

                    left = vbox {
                        label ("end Month"){
                            style{
                                backgroundColor += Color.WHITE
                            }
                        }

                        setPrefSize(450.0, 320.0)

                        vboxConstraints {
                            marginTop = 30.0
                            marginLeft = 30.0
                            marginRight = 30.0
                            marginBottom = 30.0
                        }
                        style{
                            backgroundColor += Color.rgb(30, 31, 38)
                        }
                    }
                    right = vbox {
                        label ("Add subject to people"){
                            style{
                                backgroundColor += Color.WHITE
                            }
                        }

                        setPrefSize(450.0, 302.0)

                        vboxConstraints {
                            marginTop = 30.0
                            marginLeft = 30.0
                            marginRight = 30.0
                            marginBottom = 30.0
                        }
                        style{
                            backgroundColor += Color.rgb(30, 31, 38)
                        }
                    }

                    vboxConstraints {
                        marginTop = 30.0
                        marginLeft = 30.0
                        marginRight = 30.0
                        marginBottom = 30.0
                        alignment = Pos.CENTER
                    }
                    style{
                        backgroundColor += Color.rgb(142, 172, 191)
                    }

                }

            }

        }
    }




}
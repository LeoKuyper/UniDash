package View

import javafx.beans.property.SimpleStringProperty
import javafx.collections.ObservableList
import javafx.geometry.Pos
import javafx.scene.paint.Color
import javafx.scene.text.TextAlignment
import person.Person
import subject.Subject
import tornadofx.*
import university.UniDash
import university.UniDashViewModel

class UniView: View() {

    val uniDashViewModel = UniDashViewModel(UniDash())


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

                label ("All people: " + uniDashViewModel.getAllPeople().toString()){
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
                        val model = ViewModel()
                        val search = model.bind { SimpleStringProperty() }
                        form{
                            fieldset {
                                field("Search"){
                                   textfield(search)
                                }
                            }

                            button("Search") {
                                action {
                                    uniDashViewModel.search(search.value.toString())
                                    println("Search")
                                    search.value = ""
                                }
                            }
                        }


                        tableview<Person> {
                            items = listOf(
                                    Person(0,"Jake", 0),
                                    Person(1,"Jake", 1),
                                    Person(2,"Jake", 2),
                                    Person(3,"Jake", 3)
                            ).observable()

                            column("ID",Person::idProperty)
                            column("NAME",Person::name)
                            column("TYPE",Person::type)
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

                       tableview<Subject> {
                           items = listOf(
                                   Subject("IDV", "IDV303", 100, 40, 300f),
                                   Subject("IXT", "IXT303", 100, 40, 300f)
                           ).observable()

                           column("NAME",Subject::name)
                           column("CODE",Subject::code)
                           column("CREDITS",Subject::credits)
                           column("HOURS",Subject::hours)
                           column("PRICE",Subject::price)

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

                        val model = ViewModel()
                        val name = model.bind { SimpleStringProperty() }
                        val type = model.bind { SimpleStringProperty() }


                        form{
                            fieldset {
                                field("Name"){
                                    textfield(name)
                                }

                                field("Type"){
                                    textfield(type)
                                }
                            }

                            button("Add Person") {
                                action {
                                    println(uniDashViewModel.getAllPeople().toString() + " Before Add")
                                    uniDashViewModel.addPerson(name.value.toString(),type.value.toInt())
                                    println("Added Person")

                                    println(uniDashViewModel.getAllPeople().toString() + " After Add")
                                    name.value = ""
                                    type.value = ""

                                }
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
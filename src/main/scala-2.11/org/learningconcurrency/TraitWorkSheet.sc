abstract class Widget

class Button(val label: String) extends Widget {
  def click() = {

  }
}

trait Subject {
  type Observer = {def receiveUpdate(subject: Any)}

  private var observers = List[Observer]()

  def addObserver(observer: Observer) = observers ::= observer

  def notifyObservers = observers foreach (_.receiveUpdate(this))
}


class ObservableButton(name: String) extends Button(name) with Subject {
  override def click() = {
    super.click()
    notifyObservers
  }
}


class ButtonCountObserver {
  var count = 0;

  def receiveUpdate(subject: Any) = count += 1;
}
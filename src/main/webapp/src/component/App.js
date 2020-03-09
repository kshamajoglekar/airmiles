import React, { Component } from 'react';

import '../css/App.css';
import Wall from './Wall'
import Login from './Login'
import callApi from '../fetch/base.js'

export default class App extends Component {

  constructor(props) {
    super(props);
    this.state = {
      user: '',
      city: '',
      messages: [],
      view: 'Login'
    };
  }

  componentDidMount() {
    // fetch('http://localhost:8080')
    // .then(result=> result.text())
    // .then((result) => {
    //   this.setState({ data: result })
    // })

  }



  cancelAddPerson = () => {
    this.setState({ view: 'Login' })
  }

  handleAddPerson = (firstName, lastName) => {
    this.setState({ view: 'Login' })

    let peopleNew = this.state.people
    peopleNew.push({ firstName: firstName, lastName: lastName })
    this.setState(peopleNew);
  }


  goToWall = (name, city) => {
    //callApi("goToWall")
    this.setState({ user: name, city: city })

    console.log("i am here=")
    fetch(`http://localhost:8080/posts/${name}`)
      .then(result => result.json())
      .then((result) =>  {return this.setState({ messages: result })}
      )

    // this.state.messages.map((message) => {
    //   console.log("result=" + message)
    // })
    this.setState({ view: 'Wall' })
  }


  getView = () => {
    switch (this.state.view) {
      case 'Login':
        return <Login handleLogin={this.goToWall} />
      case 'Wall':
        return <Wall messages={this.state.messages} />
    }
  }

  render() {
    return (
      <div className="App">
        {this.getView()}
      </div>
    );
  }
}
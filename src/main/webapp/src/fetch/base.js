export function goToWall(){
    fetch('http://localhost:8080')
    .then(result=> result.text())
    .then((result) => {
      this.setState({ data: result })
    })
  }
export function callApi(apiName) {
switch(apiName){
    case 'goToWall':
        goToWall();
}

  }

export default callApi
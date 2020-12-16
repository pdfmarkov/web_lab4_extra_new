<template>
	<header id="logo">
        <div id="logo_box">
            <h3>Lab 4, Var 10113</h3>
        </div>
        <div id="logo_btn_panel">
            <div id="logo_btn"></div>
        </div>
  </header>
</template>

<style>
  @import url('https://fonts.googleapis.com/css2?family=Satisfy&display=swap');
  @import url('https://fonts.googleapis.com/css2?family=Lato&display=swap');
  @import url('https://fonts.googleapis.com/css2?family=Jost&display=swap');

  #logo {
    box-shadow: 0 0 20px rgba(0,0,0,.5);
    width: 100%;
    background-color: #fff;
    display: flex;
  }

  #logo_box {
      width: 80%;
      margin: 0;
      /*font-style: italic;*/
      color: #2a2a2a;
      /*font-family: Satisfy, Lato, "Open Sans", Roboto, sans-serif;*/
      font-family: "Jost", serif;

  }

  #logo_btn_panel {
      font-size: 80%;
      float: right;
      width: 20%;
      display: flex;
  }

  #logo_btn {
      margin: auto 0 auto auto;
  }

  #logo_btn_panel button {
      margin: 2% 5px;
      padding: 8px 10px;
      float: right;
  }

  #logo h3 {
    font-size: 50px;
    padding-left: 5%;
    margin: 0;
    text-decoration: underline;
  }

  @media only all and (min-width: 1256px) {

    #logo h3{
        font-size: 300%;
    }

  }

  @media only all and (min-width: 882px) and (max-width: 1255px) {

      #logo h3{
          font-size: 300%;
      }
  }

  @media only all and (max-width: 881px) {

      #logo h3{
          font-size: 200%;
      }
  }
</style>


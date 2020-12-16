<template>
  <div id="app">
    <logo />
    <basic :access="accessTokenName" :refresh="refreshTokenName" v-if="isAuthorized" />
    <startup :access="accessTokenName" :refresh="refreshTokenName" v-else />
    <hat v-if="!isAuthorized"/>
    <basement/>
  </div>
</template>

<script>
  import saveState from 'vue-save-state'
  import logo from '@/components/logo'
  import startup from '@/components/startup'
  import basic from '@/components/basic'
  import hat from '@/components/temp_startup/hat'
  import basement from '@/components/basement'

  export default {
    name: 'app',
    components: {
      logo,
      startup,
      basic,
      hat,
      basement,
    },
    data: function() {
      return {
        accessTokenName: 'accessToken',
        refreshTokenName: 'refreshToken',
      };
    },
    computed: {
      access: function() {
        return this.$session.get(this.accessTokenName);
      },
      refresh: function() {
        return this.$session.get(this.refreshTokenName);
      },
      isAuthorized: function() {
        return !((this.access === undefined) || (this.access === null) || (this.access === ''));
      },
    },
  }
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Jost&display=swap');

  *, *:before, *:after {
    -webkit-box-sizing: border-box;
    -moz-box-sizing: border-box;
    box-sizing: border-box;
    font-family: "Jost", serif;
    font-weight: normal;
  }

  #wrap {
    font-family: Avenir, Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    color: #efefef;
    margin: 0 auto;
    padding: 0;
  }

body {
  margin: 0;
  background: linear-gradient(270deg, #fca3cc, #bce6eb);
  background-size: 400% 400%;

  -webkit-animation: Gradient 30s ease infinite;
  -moz-animation: Gradient 30s ease infinite;
  animation: Gradient 30s ease infinite;
}

@-webkit-keyframes Gradient {
  0%{background-position:0% 50%}
  50%{background-position:100% 50%}
  100%{background-position:0% 50%}
}
@-moz-keyframes Gradient {
  0%{background-position:0% 50%}
  50%{background-position:100% 50%}
  100%{background-position:0% 50%}
}
@keyframes Gradient {
  0%{background-position:0% 50%}
  50%{background-position:100% 50%}
  100%{background-position:0% 50%}
}


  @media only all and (min-width: 1245px) {
    #wrap {
      width: 1245px;
      font-size: 16px;
    }

  }

  @media only all and (min-width: 643px) and (max-width: 1244px) {
    #wrap {
      width: 643px;
      font-size: 12px;
    }
  }

  @media only all and (max-width: 642px) {
    #wrap {
      width: 320px;
      font-size: 8px;
    }
  }
</style>

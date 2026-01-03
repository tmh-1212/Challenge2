# Java Applet - Bouncing Text
Project: Chapter2_Challenge_Applet
Author: [TESFAMIKAEL HILU]

## 1. Security

Java Applets were restricted by the "sandbox" security model to prevent untrusted code from harming the user's system. Two things an applet could NOT do:

- Access the local file system (read/write files).
- Open arbitrary network connections to other servers (except the server it came from).

## 2. Modern Replacement

Applets have been replaced by modern web technologies like:

- HTML
- CSS
- JavaScript

### Example:
Using CSS and JavaScript, you could create a bouncing text animation like this:

```html
<!DOCTYPE html>
<html>
<head>
  <style>
    #text {
      position: absolute;
      top: 100px;
      left: 0;
      color: lime;
      font-size: 24px;
    }
  </style>
</head>
<body>
  <div id="text">YourName</div>
  <script>
    let text = document.getElementById("text");
    let x = 0;
    function animate() {
      x += 5;
      if (x > window.innerWidth) x = 0;
      text.style.left = x + "px";
      requestAnimationFrame(animate);
    }
    animate();
  </script>
</body>
</html>

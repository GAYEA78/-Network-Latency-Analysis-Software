# -Network-Latency-Analysis-Software


This project implements a Echo Server and Client system using both **TCP** and **UDP** communication protocols. It is designed to demonstrate basic client-server communication and provide performance metrics for the UDP protocol. In this project, I showcase my expertise in Java programming and network communication, highlighting my proficiency in both TCP and UDP protocols. I designed and implemented robust client-server architectures using multi-threading and socket programming to ensure efficient and scalable solutions. By incorporating statistical analysis for UDP performance metrics, I demonstrate my analytical skills and attention to detail. Additionally, I ensured reliable communication by handling exceptions and maintaining system stability. This project reflects my strong foundation in computer networking, software development, and my ability to deliver effective solutions to complex challenges.

---

### Overview

1. **TCP Server and Client**:
   - The TCP Server (`TCPServer.java`) listens on port 3363 and uses a thread pool to handle multiple client connections simultaneously. Each client message is echoed back to the sender.
   - The TCP Client (`TCPClient.java`) connects to the server, sends a user-provided message, and displays the echoed response from the server.

2. **UDP Server and Client**:
   - The UDP Server (`UDPServer.java`) listens on port 3363 for incoming datagrams. It receives a message from a client and echoes the same message back.
   - The UDP Client (`UDPClient.java`) sends a message to the server 10 times, measures round-trip times for each, and computes statistical metrics such as minimum, mean, maximum, and standard deviation.

---

### Features

- **TCP Implementation**:
  - Reliable and connection-oriented communication.
  - Thread pool for handling multiple simultaneous connections efficiently.
  - User input is echoed back to the sender for verification.

- **UDP Implementation**:
  - Lightweight and connectionless communication.
  - Performance analysis of round-trip times, showcasing the speed and variability of UDP communication.
  - Statistical summary of round-trip times provided in milliseconds.

---

### Usage Instructions

#### Prerequisites
- Java Development Kit (JDK) installed.
- A network environment where the server and client can communicate (local or remote).

#### Running the TCP Server and Client
1. Start the TCP Server:
   - Compile and run `TCPServer.java`.
   - The server will listen for client connections on port 3363.

2. Start the TCP Client:
   - Compile and run `TCPClient.java`.
   - Enter a message when prompted, and observe the server's echoed response.

#### Running the UDP Server and Client
1. Start the UDP Server:
   - Compile and run `UDPServer.java`.
   - The server will listen for datagrams on port 3363.

2. Start the UDP Client:
   - Compile and run `UDPClient.java`.
   - Enter a message when prompted.
   - The client will send the message to the server 10 times, display performance metrics, and print them to the console.

---

### Example Output

#### TCP Client Output:
```
Enter a message: Hello, Server!
Hello, Server!
```

#### UDP Client Output:
```
Enter a message: Hello, Server!
Min: 1.234 ms
Mean: 2.567 ms
Max: 3.890 ms
Std Dev: 0.456 ms
```

---

### Notes
- The server IP (`74.207.233.127`) is hardcoded in the client programs. Update it to the server's IP address if running on a different machine.
- Both TCP and UDP servers use port 3363. Ensure this port is open and not used by other applications.

---

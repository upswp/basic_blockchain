# basic_blockchain
basic_blockchain


# Java를 이용한 블록체인 구현

SSAFY 4기 박상우

---

## 블록체인 

- 중앙집권 방식이 아닌 분산 방식으로 진행

- 모든 거래 정보를 특정 제 3 기관이 아닌 거래를 하는 개인(Peer)이 감독 및 소유 및 배포

  ### 대표적인 블록체인 사용 범위

  1. ### 비트코인

     - #### P2P (Peer to Peer) : Server - Client 중앙 집중 관리 방식이 아닌 상호 연결된 노드들이 자원을 공유하는 형태 

     - #### 분산원장 : 분산 DB 환경

       - 노드에 자료를 분산

       - ##### 특징

         - 누구나 장부를 만들 수 있다.
         - 누구나 장부를 볼 수 있다.

       - ##### 문제점

         - 해당 장부를 믿을 수 있는가?
         - 2개의 장부가 다르면 누굴 믿을 것인가?

     - #### 합의 알고리즘 : 채굴을 통한 합의 알고리즘 진행

       - 공개되있는 데이터를 각각의 노드 모두가 업데이트를 진행할 수 있다. 그렇다면 누가 그 업데이트를 주관할 것인가 라는 문제점이 발생한다.

       - ##### POW(Proof Of Work) - 비트코인 채굴 형태

         - 해시파워(그래픽카드) 에 의한 합의
         - 전기세

       - ##### POS(Proof Of Stake)

         - 보유지분에 의한 합의

       - ##### POA(Proof Of Authority) - IBM이 대표적인 방식

         - 관리자에 의한 합의
         - 하이퍼레져

     - #### 개인키 공개키 시스템

       - 개인키 
         - 예) 통장의 비밀번호
         - 코인의 소유권 입증
       - 공개키
         - 예 ) 통장의 공개적인 계좌번호
         - 코인 주소

  2. ### 이더리움

     - Smart Contract

---

## 블록체인의 장점 / 단점 

### 장점

- 제 3 개입이 필요가 없음 (분산화 된 네트워크)
- 해킹 안전 (암호화 / Hash)
- 거래 투명 (블록체인에 기록, 언제나 누구나 열람)
- 비용절감 (시스템 유지 보수 , 보안)
  - 메인 서버를 가져다놓고 보안하는 부분이 없어지기 때문에 비용 절감 효과

### 단점

- P2P 방식 속도 저하
- 신속한 대응 불가 / 기술속도 (향후 5 - 10년정도 이후 정착가능 예상)
  - 잘못된 송금이 이뤄질 경우 대응이 힘듬.

### 향후 예상

- 현재는 중앙 집중 형태로 복사본이 움직인다면, 블록체인을 통해서 미래에는 원본을 통해 움직이는 형태가 될것이다.

---

## 블록체인의 구조

- ![image](https://user-images.githubusercontent.com/70404643/109777772-6c835280-7c47-11eb-907d-814954630143.png)

![image](https://user-images.githubusercontent.com/70404643/109777818-773de780-7c47-11eb-813e-777671832844.png)

![image](https://user-images.githubusercontent.com/70404643/109777873-815fe600-7c47-11eb-91ef-443b9631c94a.png)

- Hash를 통해서 다음 블록을 가리키도록 한다. 
- 각각의 형태가 이전 블록의 Hash값을 가지고 있고 해당 블록의 고유 Hash값을 나타낸다.

![image](https://user-images.githubusercontent.com/70404643/109777928-8e7cd500-7c47-11eb-9e5e-17c6e2d1cbb5.png)

---

## SHA256 Hash

- SHA 256 은 서명이라 생각하면 된다.
- 해당 해시값이 해당 블록을 나타내는 증명하는 서명의 역할을 하게 된다.
- Secure Hash Algorithms 256 - 2의 256승을 나타냄
- 쇄도 효과(avalanche effect) - 어떤 암호 알고리즘이 입력값에 미세한 변화를 줄 경우 출력값에 상당한 변화가 일어나는 성질을 의미

![image](https://user-images.githubusercontent.com/70404643/109777956-976da680-7c47-11eb-9280-e5bd3a27134a.png)

- Key 값을 넣으면 Hash Function에 의해서 hash값이 지정된다.
- 간혹 hash값이 중복되더라도 동일한 hash값 위치에 저장공간을 마련하여 중복을 피한다.

![image](https://user-images.githubusercontent.com/70404643/109777979-a05e7800-7c47-11eb-9f6f-70ac9192da97.png)

![image](https://user-images.githubusercontent.com/70404643/109778002-a9e7e000-7c47-11eb-95ed-36377a891683.png)

---

## 개인키 공개키

![image](https://user-images.githubusercontent.com/70404643/109778032-b3714800-7c47-11eb-9ee0-ceb7b8b1209f.png)

- 본인의 개인키를 이용하여 암호화를 진행
- 암호화를 진행한 수신자에게 전송
- 수신자는 송신자의 공개키를 가지고 암호화된 데이터를 열 수 있음

![image](https://user-images.githubusercontent.com/70404643/109778067-bcfab000-7c47-11eb-993d-f91b6cdc0653.png)

![image](https://user-images.githubusercontent.com/70404643/109778110-c84ddb80-7c47-11eb-930e-03f225853629.png)

- 개인키 - 256 비트 -> 32 바이트 -> 16진수로 표기하여 64자리 문자열로 나타남
- 공개키 - 타원을 중심으로 개인키 건너편에 공개키가 있다는 **타원 곡선 알고리즘**을 통하여 암호 알고리즘이 진행된다.

![image](https://user-images.githubusercontent.com/70404643/109778150-d4d23400-7c47-11eb-93f0-89463f3d29ab.png)

- message : a->b 1000 이라는 메세지를 적는다.
- 해당 메세지를 Private Key를 이용하여 Sign을 진행한다.
- Sign이 진행되면 Message Signature가 생성된다

![image](https://user-images.githubusercontent.com/70404643/109778190-df8cc900-7c47-11eb-87c9-7005bb06e3d7.png)

- 이후 Verify 증명 단계에서 를 이용하여 Public Key를 이용해서 받아온 Message를 온전히 잘 받아왔는지 확인한다.
- 만약 받아온 message를 임의로 수정을 할 경우 증명이 불가능 한 상황을 확인 할 수 있다.

![image](https://user-images.githubusercontent.com/70404643/109778222-e9aec780-7c47-11eb-9170-32bf3fa4c96e.png)

위의 상황을 도표화 하면 위와 같이 나타난다.

- 1번째 소유자의 개인키가 서명을 통해서 전자서명을 진행하고
- 1번째 소유자의 공개키를 이용하여 검증을 한다.

---

## Transaction

- 트랜잭션이란, 데이터베이스의 상태를 변화시키기 위해서 수행하는 작업의 단위를 뜻한다.
  - 예) 은행
    1. ATM기에 카드를 넣는다.
    2. 어떤 거래를 할지 선택을 한다.
    3. 비밀번호를 눌러 인증을 받는다.
    4. 거래를 완료한다.
  - 이 경우 전체의 거래 과정을 트랜잭션이라 볼 수 있다. 만약 하나의 과정에서 문제가 생기면 `원복`을 시키며 해당 문제를 인식하고  초기화로 돌려보내는 과정이 이뤄지는 일련의 과정 또한 트랜잭션의 조건이라 할 수 있다.

![image](https://user-images.githubusercontent.com/70404643/109778269-f6cbb680-7c47-11eb-9636-3217593e6885.png)

- Transaction에서 In / Out put이 있다는게 중요하다. 
- 이 Input / Output을 이용하여 Transcation에서 작업이 이뤄진다.

![image](https://user-images.githubusercontent.com/70404643/109778309-03500f00-7c48-11eb-831f-7fbad8edad35.png)

- genesisTransaction : 최초의 트랜잭션은 IN이 없더라도 Out으로 최초 시작을 할 수 있다.
- UTXO (unspent transaction output) : 소비되지 않은 거래 출력값
  - 일반적으로 은행에는 고객의 계좌잔고가 존재하며 비트코인에는 자신의 주소에 잔고가 존재 안함.
  - 소비되지 않는 거래 출력값만 존재한다.
- Transaction 기능
  - Spent
    - UnSpent : 미사용 트랜잭션
    - Spent : 사용 트랜잭션
  - Confrimed : OutPut이 이뤄지게 된다면 블록에 저장이 되어야 한다.
    - Unconfirmed : 블록에 미 저장
      - 블록이 저장이 안될경우 롤백을 처리
    - Confirmed : 블록에 저장된 상태
      - 올바르게 output이 되었을 경우

---

## 블록체인 구조

### LinkedList

- 자료구조 관점

### Hash

- SHA256 암호화, Digital Signature 관점
- Key값이 Hash를 통해 암호화를 이뤄짐.

# Wallet & Transaction

---

## 시스템 구조

![image](https://user-images.githubusercontent.com/70404643/109924611-e24cf400-7d03-11eb-8777-57bc8ec5ef8a.png)

---

## Wallet 기능

- Wallet의 기능

  - 공개키, 개인키의 의미는 트랜잭션의 검증수단

  - 트랜잭션이 생성되고 처리되는 과정에서 개인키로 트랜잭션에 서명하고 공개키로 올바른 서명인지 판단.

  - ---

    

  - 트랜잭션을 일으키는 지갑이 본인의 개인키로 디지털 서명을 암호화, 공개키로 해당 트랜잭션을 복호화 하여 유효한 트랜잭션인지 확인한다.

  - ---

  - 보통 이 키 쌍을 가르켜 `KeyPair`라고 한다. 키 쌍을 만드는데에는 타원 곡선 암호(Elliptic-curve cryptography)가 사용된다.

  - ---

  - Wallet은 블록체인의 가장 밑바탕이 되는 프로그램이다. 지갑 프로그램은 각 클라이언트들이 모두 설치가 되있다는 가정에 진행된다.

  - 지갑에서 Transaction을 생성한다. 

  - 수신자는 오픈되있는 공개키를 알고있어야한다.

---

## 구성항목 설명

- ### Block

  - | 구성항목       | 설명                                  |
    | -------------- | ------------------------------------- |
    | 항목           | Hash, preHash, data, timestamp, nonce |
    | calculateHash  | 해쉬 값 구하는 기능                   |
    | mineBlock      | 채굴 기능                             |
    | addTransaction | 검증, 트랜잭션 리스트 추가            |

    

  - ```java
    package Part2;
    
    import java.util.ArrayList;
    import java.util.Date;
    
    public class Block {
        //"0000157", 인간의 지문(고유한키값)
        public String hash;
        // 123 이전 인간에 대한 지문값
        public String previousHash;
        //값을 담는 부분 전송내역...
        public String data;
        //12.2
        public long timeStamp;
        //1000,1221 random
        public int nonce;
        public String merkleRoot;
    
        public ArrayList<Transaction> transactionList = new ArrayList<>();
    
        public Block(String data, String previousHash){
            this.data = data;
            this.previousHash = previousHash;
            //20190210121212
            this.timeStamp = new Date().getTime();
            this.hash = caculateHash();
        }
    
        public String caculateHash(){
            String hash = BlockUtil.applySha256(previousHash + data
                    + Integer.toString(nonce)
                    + Long.toString(timeStamp)
                    + merkleRoot);
            return hash;
        }
    
        public void mineBlock(int difficulty){
            merkleRoot = BlockUtil.getMerkleRoot(transactionList);
            //target = difficulty에 따라서 값을 자리 앞에 0을 몇개 붙일지 정함.
            String target = BlockUtil.getDifficultyString(difficulty);
            // 작성된 hash의 앞자리가 difficulty까지 0이 일치할때까지 hash를 생성해라.
            while(!hash.substring(0,difficulty).equals(target)){
                nonce++;
                hash = caculateHash();
                System.out.println("nonce:"+nonce+" "+"target:"+target+" "+"hash:"+hash);
            }
            System.out.println("$$Mined hash$$: "+hash+" nonce: "+nonce);
            System.out.println("===Block Mined!!! : " + hash);
        }
    
        public boolean addTransaction(Transaction tx) {
            if(tx == null) return false;
            if((!"0".equals(previousHash))) {
                if(tx.processTransaction() != true) {
                    return false;
                }
            }
            transactionList.add(tx);
            System.out.println("===Transaction added to Block");
            return true;
        }
    }
    
    ```

- ### BlockUtil

  - | method              | 설명 |
    | ------------------- | ---- |
    | applySha256         |      |
    | applyECDSASig       |      |
    | verifyECDSASig      |      |
    | getJson             |      |
    | getDifficultyString |      |
    | getStringFromKey    |      |
    | getMerkleRoot       |      |

    

  - ```java
    package Part2;
    
    import com.google.gson.GsonBuilder;
    
    import java.security.*;
    import java.util.ArrayList;
    import java.util.Base64;
    import java.util.List;
    
    public class BlockUtil {
    
    
        //Applies Sha256 to a string and returns the result.
        public static String applySha256(String input){
    
            try {
                MessageDigest digest = MessageDigest.getInstance("SHA-256");
    
    
                byte[] hash = digest.digest(input.getBytes("UTF-8"));
    
                StringBuffer hexString = new StringBuffer(); // This will contain hash as hexidecimal
                for (int i = 0; i < hash.length; i++) {
                    String hex = Integer.toHexString(0xff & hash[i]);
                    if(hex.length() == 1) hexString.append('0');
                    hexString.append(hex);
                }
                return hexString.toString();
            }
            catch(Exception e) {
                throw new RuntimeException(e);
            }
        }
    
        //Applies ECDSA Signature and returns the result ( as bytes ).
        public static byte[] applyECDSASig(PrivateKey privateKey, String input) {
            Signature dsa;
            byte[] output = new byte[0];
            try {
                dsa = Signature.getInstance("ECDSA", "BC");
                dsa.initSign(privateKey);
                byte[] strByte = input.getBytes();
                dsa.update(strByte);
                byte[] realSig = dsa.sign();
                output = realSig;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            return output;
        }
    
        //Verifies a String signature
    
        /**
         * 받아온 내용을 확인하는 단계, 라이브러리를 이용
         * @param publicKey
         * @param data
         * @param signature
         * @return
         */
        public static boolean verifyECDSASig(PublicKey publicKey, String data, byte[] signature) {
            try {
                Signature ecdsaVerify = Signature.getInstance("ECDSA", "BC");
                ecdsaVerify.initVerify(publicKey);
                ecdsaVerify.update(data.getBytes());
                return ecdsaVerify.verify(signature);
            }catch(Exception e) {
                throw new RuntimeException(e);
            }
        }
    
        //Short hand helper to turn Object into a json string
        public static String getJson(Object o) {
            return new GsonBuilder().setPrettyPrinting().create().toJson(o);
        }
    
        //Returns difficulty string target, to compare to hash. eg difficulty of 5 will return "00000"
        public static String getDifficultyString(int difficulty) {
            return new String(new char[difficulty]).replace('\0', '0');
        }
    
        public static String getStringFromKey(Key key) {
            return Base64.getEncoder().encodeToString(key.getEncoded());
        }
    
        public static String getMerkleRoot(ArrayList<Transaction> transactions) {
            int count = transactions.size();
    
            List<String> previousTreeLayer = new ArrayList<String>();
            for(Transaction transaction : transactions) {
                previousTreeLayer.add(transaction.transactionId);
            }
            List<String> treeLayer = previousTreeLayer;
    
            while(count > 1) {
                treeLayer = new ArrayList<String>();
                for(int i=1; i < previousTreeLayer.size(); i+=2) {
                    treeLayer.add(applySha256(previousTreeLayer.get(i-1) + previousTreeLayer.get(i)));
                }
                count = treeLayer.size();
                previousTreeLayer = treeLayer;
            }
    
            String merkleRoot = (treeLayer.size() == 1) ? treeLayer.get(0) : "";
            return merkleRoot;
        }
    
    }
    
    ```

- ### Transaction

  - | method             | 설명                                                         |
    | ------------------ | ------------------------------------------------------------ |
    | Transaction        | Transaction 생성                                             |
    | processTransaction | Transaction 검증해주기, 중간에 에러가 발생하면 정지          |
    | calculateHash      |                                                              |
    | getInputValue      | TransactionInput에 담겨있는 UTXO의 value값을 total로 합쳐줌  |
    | verifySignature    | sender와 reciepient와 value를 넣어줘서 String으로 선언한 변수 data에 넣어줌 |
    | generateSignature  | 서명 생성                                                    |

  - ```java
    package Part2;
    
    import javax.naming.CompositeName;
    import java.security.PrivateKey;
    import java.security.PublicKey;
    import java.util.ArrayList;
    
    public class Transaction {
        // 송신자의 공개키
        public String transactionId;
        // 보내는 사람 주소
        public PublicKey sender;
        // 받는 사람의 주소
        public PublicKey reciepient;
        // 보내는 금액
        public float value;
        // 서명
        public byte[] signature;
    
        public ArrayList<TransactionInput> inputs = new ArrayList<>();
        public ArrayList<TransactionOutput> outputs = new ArrayList<>();
    
        public static int sequence = 0;
    
        /**
         * Transaction 생성
         *
         * @param from   보내는 사람
         * @param to     받는사람
         * @param value  금액
         * @param inputs 이전 트랜잭션에 대한 input
         */
        public Transaction(PublicKey from, PublicKey to, float value, ArrayList<TransactionInput> inputs) {
            this.sender = from;
            this.reciepient = to;
            this.value = value;
            this.inputs = inputs;
        }
    
        /**
         * Tx 검증해주기, 중간에 에러가 발생하면 정지
         *
         * @return Tx 검증이 올바르면 true
         */
        public boolean processTransaction() {
            // 1. 서명 검증
            if (!verifySignature()) return false;
    
            // 2. 메인합수에 임시 저장된 TxOutId로 UTXO(사용되지 않은게 맞는지 확인)
            /**
             * 여기서의 TransactionInput은 이전 genesis or 이전 TX의 Out에 해당한다.
             * 그러므로 여기서 해당 Input이 전달되어 넘어온 값을 value값을 체크하고 송금이 가능한지 체크한다.
             */
            // wallet에서 만들어진 inputs를 가져온다.
            for (TransactionInput i : inputs) {
                // main에서 관리하고있는 TXoutPut을 가져오고 가져온 값을 현재의 UTXO에 넣어준다.
                i.UTXO = Main.UTXOs.get(i.transactionOutputId);
    
            }
            // 3. 최소단위 0.1f 를 넘는지 체크
            if (getInputValue() < Main.minimumTransaction) return false;
    
            // 4. TxOutPut 100 value : 40,60
            transactionId = calculateHash();
            float leftOver = getInputValue() - value;
                // 40코인 전송
            outputs.add(new TransactionOutput(this.reciepient, value, transactionId));
                // 60 코인 저장
            outputs.add(new TransactionOutput(this.sender, leftOver, transactionId));
    
            // 5. output to Unspent list(output들을 main함수 쪽으로 연결시켜주기)
            for (TransactionOutput o : outputs){
                Main.UTXOs.put(o.id, o);
            }
            // 6. remove Txinput(기존의 main에 설정되있던 TXout을 삭제하기)
            for (TransactionInput i : inputs){
                if (i.UTXO.id == null)  continue;
                Main.UTXOs.remove(i.UTXO.id);
            }
    
            return true;
        }
    
        public String calculateHash() {
            sequence++;
            return BlockUtil.applySha256(BlockUtil.getStringFromKey(sender) +
                    BlockUtil.getStringFromKey(reciepient) +
                    Float.toString(value) + sequence);
        }
    
        private float getInputValue() {
            float total = 0;
            for (TransactionInput i : inputs) {
                if (i.UTXO == null) continue;
                total += i.UTXO.value;
            }
            return total;
        }
    
    
        /**
         * sender와 reciepient와 value를 넣어줘서 String으로 선언한 변수 data에 넣어줌
         *
         * @return BlockUtil.verifyECDSASig로 전송
         */
        public boolean verifySignature() {
            String data = BlockUtil.getStringFromKey(sender) + BlockUtil.getStringFromKey(reciepient) + Float.toString(value);
            return BlockUtil.verifyECDSASig(sender, data, signature);
        }
    
        /**
         * 서명 생성
         * 서명의 조건은
         * 1. 보내는사람, 받는사람, 금액 data로 저장
         * 2. 본인의 PrivateKey가 들어감.
         *
         * @param privateKey
         */
        public void generateSignature(PrivateKey privateKey) {
            String data = BlockUtil.getStringFromKey(sender) + BlockUtil.getStringFromKey(reciepient) + Float.toString(value);
            signature = BlockUtil.applyECDSASig(privateKey, data);
        }
    
    
    }
    ```

- ### TransactionInput

  - TranscationInput은 앞서 있는 TransactionOutput을 가져온다.

  - ```java
    package Part2;
    
    /**
     * TranscationInput은 앞서 있는 TransactionOutput을 가져온다.
     * 즉, 이 부분에서 해당 Output값이 있는지 체크하는 용도로 사용이 된다.
     */
    public class TransactionInput {
        // TransactionOutputs -> transactionId
        public String transactionOutputId;
        //Unspent transaction output
        public TransactionOutput UTXO;
    
        public TransactionInput(String transactionOutputId) {
            this.transactionOutputId = transactionOutputId;
        }
    }
    
    ```

- ### TransactionOutput

  - 받는 사람의 주소가 그사람의 계좌주소와 같은지 확인

  - ```java
    package Part2;
    
    import java.security.PublicKey;
    
    public class TransactionOutput {
        public String id;
        //받는사람
        public PublicKey reciepient;
        //금액
        public float value;
        //거래에 대한 Tx ID
        public String parentTransactionId;
    
        /**
         * TransactionOutput 생성자
         * @param reciepient 받는사람
         * @param value 금액
         * @param parentTransactionId 거래에 대한 TX ID
         */
        public TransactionOutput(PublicKey reciepient, float value, String parentTransactionId) {
            this.reciepient = reciepient;
            this.value = value;
            this.parentTransactionId = parentTransactionId;
            this.id = BlockUtil.applySha256(BlockUtil.getStringFromKey(reciepient)+Float.toString(value)+parentTransactionId);
        }
    
        //
    
        /**
         * 받는 사람의 주소가 그사람의 계좌주소와 같은지 확인
         * 받는 사람 주소가 == 그 사람의 공계키와 같다면 동일인
         * @param publicKey
         * @return
         */
        public boolean isMine(PublicKey publicKey) {
            return (publicKey == reciepient);
        }
    }
    
    ```

- ### Wallet

  - Wallet의 구성

    - | 구성 항목  | 설명                     |
      | ---------- | ------------------------ |
      | 개인키     | 비밀번호                 |
      | 공개키     | 계좌번호                 |
      | UTXO       | 보내야할 코인에 트랜잭션 |
      | 잔고확인   | 잔고확인                 |
      | 송신(잔액) | 잔고 확인 후 송신        |

  - Wallet의 기능

    - |            구성 항목             |   분류   | 설명                                                         |
      | :------------------------------: | :------: | ------------------------------------------------------------ |
      |        공개키(Public Key)        |          | 누구에게나 공개 (계좌번호 같은 역할을 함)                    |
      |       개인키(Private Key)        |          | 사용자 본인만 알아야하는 (비밀번호 같은 역할을 함)           |
      |        타원곡선 알고리즘         | 알고리즘 | 공개키 개인키를 쌍으로 만들어주는 알고리즘.                  |
      | UTXO(Unspent Transaction Output) |   내용   | 사용되지 않은 TransactionOutput(Unspent 상태)<br />TxOutput은 생성 항목이 (받는사람, 금액, parentTransacionId)이다.<br />말 그대로 누군가에게 돈을 그 사람에 계좌에 보내겠다는 역할을 한다.<br />Main함수에서는 이것을 <id , TransationOutput>로 관리한다. |
      |                                  | 자료구조 | 관리하는 자료구조 형태에는<br />HashMap<String, TransactionOutput>로 관리한다. |
      |                                  | 시나리오 | 1. 100코인을 계좌번호 0xa에 보낸다.<br />2. TxOutput은 생성항목이(0xa, 100, parentTransactionId)로 저장된다.<br />3.이것을 메인 함수에서는 HashMap(key, TxOutput)로 메모리 상테로 저장된다. |

  - ```java
    package Part2;
    
    import java.security.*;
    import java.security.spec.ECGenParameterSpec;
    import java.util.ArrayList;
    import java.util.HashMap;
    import java.util.Map;
    
    public class Wallet {
        public PrivateKey privateKey;
        public PublicKey publicKey;
    
        public HashMap<String,TransactionOutput> UTXO_Wallet = new HashMap<String,TransactionOutput>();
    
        public Wallet() {
            generateKeyPair();
        }
        // 잔고 확인 기능
        public float getBalance() {
            float total = 0;
            for (Map.Entry<String, TransactionOutput> item: Main.UTXOs.entrySet()){
                TransactionOutput UTXO = item.getValue();
                if(UTXO.isMine(publicKey)) {
                    UTXO_Wallet.put(UTXO.id,UTXO);
                    total += UTXO.value ;
                }
            }
            return total;
        }
        // 송신기능
        public Transaction sendFunds(PublicKey _recipient,float value ) {
            if(getBalance() < value) {
                System.out.println("Not Enough~~!");
                return null;
            }
            ArrayList<TransactionInput> inputs = new ArrayList<TransactionInput>();
    
            float total = 0;
            for (Map.Entry<String, TransactionOutput> item: UTXO_Wallet.entrySet()){
                TransactionOutput UTXO = item.getValue();
                total += UTXO.value;
                inputs.add(new TransactionInput(UTXO.id));
                if(total > value) break;
            }
    
            Transaction newTransaction = new Transaction(publicKey, _recipient , value, inputs);
            newTransaction.generateSignature(privateKey);
    
            for(TransactionInput input: inputs){
                UTXO_Wallet.remove(input.transactionOutputId);
            }
    
            return newTransaction;
        }
    
        public void generateKeyPair() {
            try {
                KeyPairGenerator keyGen = KeyPairGenerator.getInstance("ECDSA","BC");
                SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
                ECGenParameterSpec ecSpec = new ECGenParameterSpec("prime192v1");
    
                keyGen.initialize(ecSpec, random);
                KeyPair keyPair = keyGen.generateKeyPair();
    
                privateKey = keyPair.getPrivate();
                publicKey = keyPair.getPublic();
    
            }catch(Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
    
    ```

- ### Main

  - ```java
    package Part2;
    
    import Part1.BlockUtil;
    
    import java.security.Security;
    import java.util.ArrayList;
    import java.util.HashMap;
    
    public class Main {
        public static ArrayList<Block> blockChain = new ArrayList<>();
        public static int difficulty = 2;
        //지감 선언 A
        public static Wallet walletA;
        //지갑 선언 B
        public static Wallet walletB;
    
        //최초의 Transaction genesisTransaction 선언
        public static Transaction genesisTransaction;
        // Transaction을 담을 HashMap형태의 UTXOs를 선언
        public static HashMap<String, TransactionOutput> UTXOs = new HashMap<String, TransactionOutput>();
        // 최소단위로 이체할 금액.
        public static float minimumTransaction = 0.1f;
    
    
        public static void main(String[] args) {
    
            Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
            /*
             * 1. 지감 생성
             */
            walletA = new Wallet();
            walletB = new Wallet();
            // 코인을 주는 wallet , 채굴이 일어났을때 코인을 주는 wallet
            Wallet coinbase = new Wallet();
    
            /*
             * 2. genesis transaction을 생성
             */
            // coinbase, 받는사람, 보내는 금액, TransacionInput은 genesis여서 null처리.
            genesisTransaction = new Transaction(coinbase.publicKey, walletA.publicKey, 100f, null);
            //genesis TX에서 서명을 생성한다.
            genesisTransaction.generateSignature(coinbase.privateKey);
            //genesis TX에서 transactionId를 0으로 생성
            genesisTransaction.transactionId = "0";
            //genesis TX에서 transaction output리스트를 생성한다.
            genesisTransaction.outputs.add(
                    new TransactionOutput(genesisTransaction.reciepient, genesisTransaction.value, genesisTransaction.transactionId));
            /*
             * 3. Main 함수내 UTXO에 저장한다.
             */
            UTXOs.put(genesisTransaction.outputs.get(0).id, genesisTransaction.outputs.get(0));
            /*
             *  4. genesisBlock 생성
             */
            Block genesisBlock = new Block("Genesis block", "0");
            genesisBlock.addTransaction(genesisTransaction);
            addBlock(genesisBlock);
            System.out.println("");
            /*
             * 5. Block 1 생성
             */
            Block block1 = new Block("First block", genesisBlock.hash);
            System.out.println("1. walletA.getBalance(): " + walletA.getBalance());
            System.out.println("2. block1 add 전 " + walletA.getBalance());
            // Wallet A에서 B로 전송
            block1.addTransaction(walletA.sendFunds(walletB.publicKey, 40f));
            addBlock(block1);
            System.out.println("3. walletA.getBalance(): " + walletA.getBalance());
            System.out.println("4. walletB.getBalance(): " + walletB.getBalance());
    
    
            String blockchainJson = BlockUtil.getJson(blockChain);
            System.out.println("\nThe block chain: ");
            System.out.println(blockchainJson);
        }
    
        public static void addBlock(Block newBlock) {
            newBlock.mineBlock(difficulty);
            blockChain.add(newBlock);
        }
    }
    
    ```

  - 


package com.techdisqus.services.contract.model;

import io.reactivex.Flowable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.0.1.
 */
public class Transactionfee extends Contract {
    private static final String BINARY = "608060405234801561001057600080fd5b506040516040806102e38339810180604052604081101561003057600080fd5b50805160209091015160018054600160a060020a03909316600160a060020a0319909316929092179091556000556102768061006d6000396000f3fe608060405260043610610066577c0100000000000000000000000000000000000000000000000000000000600035046310fb7bc6811461006b57806327e235e314610092578063d0f452dd146100d2578063ddca3f43146100dc578063f7260d3e146100f1575b600080fd5b34801561007757600080fd5b5061008061012f565b60408051918252519081900360200190f35b34801561009e57600080fd5b50610080600480360360208110156100b557600080fd5b503573ffffffffffffffffffffffffffffffffffffffff1661014c565b6100da61015e565b005b3480156100e857600080fd5b50610080610228565b3480156100fd57600080fd5b5061010661022e565b6040805173ffffffffffffffffffffffffffffffffffffffff9092168252519081900360200190f35b60015473ffffffffffffffffffffffffffffffffffffffff163190565b60026020526000908152604090205481565b6000805460015460405160643490930292909204929173ffffffffffffffffffffffffffffffffffffffff909116906108fc84150290849084818181858888f16001805473ffffffffffffffffffffffffffffffffffffffff90811660009081526002602090815260409182902080548c01905592548151338152921692820192909252808201899052821515606082015290519196507f4a7ca93981c43b6021cfef8fa7764ad1a6abd748f97622b8fc50d887bf603c6495508190036080019350915050a15050565b60005481565b60015473ffffffffffffffffffffffffffffffffffffffff168156fea165627a7a723058208ee568d92c87f2a4c5830b4dc3a609daa00e364fd6743dad6ead88a78294c33e0029";

    public static final String FUNC_GETRECEIVERBALANCE = "getReceiverBalance";

    public static final String FUNC_BALANCES = "balances";

    public static final String FUNC_SENDTRX = "sendTrx";

    public static final String FUNC_FEE = "fee";

    public static final String FUNC_RECEIVER = "receiver";

    public static final Event SENT_EVENT = new Event("Sent", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Uint256>() {}, new TypeReference<Bool>() {}));
    ;

    @Deprecated
    protected Transactionfee(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Transactionfee(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Transactionfee(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Transactionfee(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<BigInteger> getReceiverBalance() {
        final Function function = new Function(FUNC_GETRECEIVERBALANCE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> balances(String param0) {
        final Function function = new Function(FUNC_BALANCES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> sendTrx(BigInteger weiValue) {
        final Function function = new Function(
                FUNC_SENDTRX, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteCall<BigInteger> fee() {
        final Function function = new Function(FUNC_FEE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<String> receiver() {
        final Function function = new Function(FUNC_RECEIVER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public List<SentEventResponse> getSentEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(SENT_EVENT, transactionReceipt);
        ArrayList<SentEventResponse> responses = new ArrayList<SentEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            SentEventResponse typedResponse = new SentEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.from = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.to = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse.sent = (Boolean) eventValues.getNonIndexedValues().get(3).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<SentEventResponse> sentEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, SentEventResponse>() {
            @Override
            public SentEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(SENT_EVENT, log);
                SentEventResponse typedResponse = new SentEventResponse();
                typedResponse.log = log;
                typedResponse.from = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.to = (String) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
                typedResponse.sent = (Boolean) eventValues.getNonIndexedValues().get(3).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<SentEventResponse> sentEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(SENT_EVENT));
        return sentEventFlowable(filter);
    }

    @Deprecated
    public static Transactionfee load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Transactionfee(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Transactionfee load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Transactionfee(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Transactionfee load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Transactionfee(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Transactionfee load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Transactionfee(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Transactionfee> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String _receiver, BigInteger _fee) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_receiver), 
                new org.web3j.abi.datatypes.generated.Uint256(_fee)));
        return deployRemoteCall(Transactionfee.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<Transactionfee> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String _receiver, BigInteger _fee) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_receiver), 
                new org.web3j.abi.datatypes.generated.Uint256(_fee)));
        return deployRemoteCall(Transactionfee.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<Transactionfee> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _receiver, BigInteger _fee) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_receiver), 
                new org.web3j.abi.datatypes.generated.Uint256(_fee)));
        return deployRemoteCall(Transactionfee.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<Transactionfee> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _receiver, BigInteger _fee) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_receiver), 
                new org.web3j.abi.datatypes.generated.Uint256(_fee)));
        return deployRemoteCall(Transactionfee.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static class SentEventResponse {
        public Log log;

        public String from;

        public String to;

        public BigInteger amount;

        public Boolean sent;
    }
}
